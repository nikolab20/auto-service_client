package controller;

import domain.Klijent;
import domain.Racun;
import domain.Radnik;
import java.io.File;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Controller {

    /**
     * The instance of the controller class. The instance created on this site
     * ensures its uniqueness for the whole project.
     *
     * @return the instance of the controller class.
     */
    @Getter
    private static Controller instance = new Controller();

    /**
     * A logical value that represents whether the server is set to the default
     * configuration or not.
     *
     * @param defaultConfig is the boolean value for the attribute defaultConfig
     * of this class.
     * @return the boolean value.
     */
    @Getter
    @Setter
    private boolean defaultConfig;

    @Getter
    @Setter
    private Locale locale;

    @Getter
    @Setter
    private Radnik radnik;

    /**
     * The constructor of this class without any parameters.
     */
    private Controller() {

    }

    /**
     * Method for reading a data from properties file.
     *
     * @return An object of the {@link Properties} class that contains data from
     * a file.
     * @throws IOException if file doesn't exist.
     */
    public Properties readPropertiesFile() throws IOException {
        FileInputStream in = new FileInputStream("props/conn.properties");
        Properties props = new Properties();
        props.load(in);

        return props;
    }

    /**
     * Method for putting data into properties file.
     *
     * @param host is String that represents host of the server.
     * @param port is String that represents port of the server.
     * @throws IOException if file doesn't exist.
     */
    public void writeIntoPropertiesFile(String host, String port) throws IOException {
        FileInputStream in = new FileInputStream("props/conn.properties");
        Properties props = new Properties();
        props.load(in);

        props.setProperty("host", host);
        props.setProperty("port", port);
    }

    /**
     * Method for initial adjusting the form.
     *
     * @param form is the form tuned by this method.
     * @param mainPanel is the content panel of this form.
     */
    public void defaultPrepareForm(JFrame form) {
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.pack();
        form.setLocationRelativeTo(null);
        URL imageUrl = ClassLoader.getSystemResource("img/transportation.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        form.setIconImage(icon.getImage());
    }

    /**
     * Method for putting icon on label.
     *
     * @param file is the image file for the icon.
     * @param label is the label on which the method places the icon.
     */
    public void setIconToLabel(String file, JLabel label) {
        URL imageUrl = ClassLoader.getSystemResource(file);
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        label.setIcon(imageIcon);
    }

    /**
     * Method for putting icon on button.
     *
     * @param file is the image file for the icon.
     * @param button is the button on which the method places the icon.
     */
    public void setIconToButton(String file, JButton button) {
        URL imageUrl = ClassLoader.getSystemResource(file);
        ImageIcon imageIcon = new ImageIcon(imageUrl);
        button.setIcon(imageIcon);
    }

    public void setToolTipTextToButton(JButton button, String name, ResourceBundle resourceBundle) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setToolTipText(resourceBundle.getString("client_" + name + "_toolTip"));
    }

    public String generateRandomString() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 12;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public void saveReportBillFromDate(List<Racun> racuni, String path) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            String[] columnNames = new String[]{"Redni broj", "Broj racuna", "Datum izdavanja",
                "Ukupna vrednost (RSD)", "Ukupna vrednost sa porezom (RSD)", "Klijent",
                "Radnik"};

            makeTitle(sheet, "Izvestaj", 0, 6, IndexedColors.GREY_25_PERCENT.getIndex(), FillPatternType.ALT_BARS,
                    IndexedColors.WHITE.getIndex(), true, workbook);

            Row row = sheet.createRow(1);
            createHeader(row, columnNames);

            defaultSetCellOfRow(row, workbook, IndexedColors.BLUE_GREY.getIndex(), FillPatternType.SOLID_FOREGROUND,
                    IndexedColors.WHITE.getIndex(), true);

            int rownum = 2;
            for (Racun racun : racuni) {
                row = sheet.createRow(rownum++);
                createCellsBill(racun, row, rownum - 2);
            }

            PropertyTemplate pt = new PropertyTemplate();
            pt.drawBorders(new CellRangeAddress(0, rownum - 1, 0, 6),
                    BorderStyle.THIN, BorderExtent.ALL);
            pt.applyBorders(sheet);

            for (int i = 2; i <= sheet.getPhysicalNumberOfRows() - 1; i++) {
                defaultSetCellOfRow(sheet.getRow(i), workbook, IndexedColors.WHITE.getIndex(), FillPatternType.SOLID_FOREGROUND,
                        IndexedColors.BLACK.getIndex(), false);
            }

            rownum += 1;
            row = sheet.createRow(rownum);

            Cell cell = row.createCell(0);
            cell.setCellValue("Total:");

            setFormulaToCell("SUM(D" + 3 + ":D" + (rownum - 1) + ")", row, 3);
            setFormulaToCell("SUM(E" + 3 + ":E" + (rownum - 1) + ")", row, 4);

            pt.drawBorders(new CellRangeAddress(rownum, rownum, 0, 6),
                    BorderStyle.THIN, BorderExtent.ALL);
            pt.applyBorders(sheet);

            defaultSetCellOfRow(sheet.getRow(rownum), workbook, IndexedColors.GREY_25_PERCENT.getIndex(), FillPatternType.ALT_BARS,
                    IndexedColors.WHITE.getIndex(), true);

            setColumnAutoSize(sheet, columnNames.length);

            FileOutputStream out = new FileOutputStream(new File(path + ".xlsx"));
            workbook.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setColumnAutoSize(XSSFSheet sheet, int numberOfColumns) {
        for (int i = 0; i < numberOfColumns; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private void createHeader(Row row, String[] columnNames) {
        Cell cell;

        for (int i = 0; i < columnNames.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
        }
    }

    private void createCellsBill(Racun racun, Row row, int i) {
        Cell cell = row.createCell(0);
        cell.setCellValue(i);

        cell = row.createCell(1);
        cell.setCellValue(racun.getBrojRacuna());

        cell = row.createCell(2);
        cell.setCellValue(new SimpleDateFormat("dd.MM.yyyy.").format(racun.getDatumIzdavanja()));

        cell = row.createCell(3);
        cell.setCellValue(Double.parseDouble(racun.getUkupnaVrednost() + ""));

        cell = row.createCell(4);
        cell.setCellValue(Double.parseDouble(racun.getUkupnaVrednostSaPorezom() + ""));

        cell = row.createCell(5);
        cell.setCellValue(racun.getKlijent().getImeKlijenta() + " " + racun.getKlijent().getPrezimeKlijenta());

        cell = row.createCell(6);
        cell.setCellValue(racun.getRadnik().getImeRadnika() + " " + racun.getRadnik().getPrezimeRadnika());
    }

    private void makeTitle(XSSFSheet sheet, String title, int i, int j, short foregroundColor, FillPatternType fillPatern,
            short fontColor, boolean isBold, XSSFWorkbook workbook) {
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(title);
        CellRangeAddress mergedCell = new CellRangeAddress(0, i, 0, j);
        sheet.addMergedRegion(mergedCell);

        cell.getCellStyle().setFillBackgroundColor(foregroundColor);
        cell.getCellStyle().setFillPattern(fillPatern);
        Font font = workbook.createFont();
        font.setColor(fontColor);
        font.setBold(isBold);
        cell.getCellStyle().setFont(font);
        CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell, VerticalAlignment.CENTER);
    }

    private void defaultSetCellOfRow(Row row, XSSFWorkbook workbook, short foregraoundColor, FillPatternType fillPatern,
            short fontColor, boolean isBold) {
        for (Cell cell : row) {
            cell.getCellStyle().setFillForegroundColor(foregraoundColor);
            cell.getCellStyle().setFillPattern(fillPatern);
            Font font = workbook.createFont();
            font.setColor(fontColor);
            font.setBold(isBold);
            cell.getCellStyle().setFont(font);
            CellUtil.setAlignment(cell, HorizontalAlignment.CENTER);
            CellUtil.setVerticalAlignment(cell, VerticalAlignment.CENTER);
        }
    }

    private void setFormulaToCell(String formula, Row row, int cellIndex) {
        Cell cell = row.createCell(cellIndex);
        cell.setCellFormula(formula);
    }

    public void saveReportNewClientsFromDate(List<Klijent> klijenti, String path) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            String[] columnNames = new String[]{"Redni broj", "Sifra klijenta", "Ime klijenta", "Prezime klijenta",
                "Broj poseta", "Dug"};

            makeTitle(sheet, "Novi klijenti", 0, 5, IndexedColors.GREY_25_PERCENT.getIndex(), FillPatternType.ALT_BARS,
                    IndexedColors.WHITE.getIndex(), true, workbook);

            Row row = sheet.createRow(1);
            createHeader(row, columnNames);

            defaultSetCellOfRow(row, workbook, IndexedColors.BLUE_GREY.getIndex(), FillPatternType.SOLID_FOREGROUND,
                    IndexedColors.WHITE.getIndex(), true);

            int rownum = 2;
            for (Klijent klijent : klijenti) {
                row = sheet.createRow(rownum++);
                createCellsClient(klijent, row, rownum - 2);
            }

            PropertyTemplate pt = new PropertyTemplate();
            pt.drawBorders(new CellRangeAddress(0, rownum - 1, 0, 5),
                    BorderStyle.THIN, BorderExtent.ALL);
            pt.applyBorders(sheet);

            for (int i = 2; i <= sheet.getPhysicalNumberOfRows() - 1; i++) {
                defaultSetCellOfRow(sheet.getRow(i), workbook, IndexedColors.WHITE.getIndex(), FillPatternType.SOLID_FOREGROUND,
                        IndexedColors.BLACK.getIndex(), false);
            }

            setColumnAutoSize(sheet, columnNames.length);

            FileOutputStream out = new FileOutputStream(new File(path + ".xlsx"));
            workbook.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveReportClientsDebt(List<Klijent> klijenti, String path) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            String[] columnNames = new String[]{"Redni broj", "Sifra klijenta", "Ime klijenta", "Prezime klijenta",
                "Broj poseta", "Dug"};

            makeTitle(sheet, "Dugovanja klijenata", 0, 5, IndexedColors.GREY_25_PERCENT.getIndex(), FillPatternType.ALT_BARS,
                    IndexedColors.WHITE.getIndex(), true, workbook);

            Row row = sheet.createRow(1);
            createHeader(row, columnNames);

            defaultSetCellOfRow(row, workbook, IndexedColors.BLUE_GREY.getIndex(), FillPatternType.SOLID_FOREGROUND,
                    IndexedColors.WHITE.getIndex(), true);

            int rownum = 2;
            for (Klijent klijent : klijenti) {
                row = sheet.createRow(rownum++);
                createCellsClient(klijent, row, rownum - 2);
            }

            PropertyTemplate pt = new PropertyTemplate();
            pt.drawBorders(new CellRangeAddress(0, rownum - 1, 0, 5),
                    BorderStyle.THIN, BorderExtent.ALL);
            pt.applyBorders(sheet);

            for (int i = 2; i <= sheet.getPhysicalNumberOfRows() - 1; i++) {
                defaultSetCellOfRow(sheet.getRow(i), workbook, IndexedColors.WHITE.getIndex(), FillPatternType.SOLID_FOREGROUND,
                        IndexedColors.BLACK.getIndex(), false);
            }
            
            rownum += 1;
            row = sheet.createRow(rownum);

            Cell cell = row.createCell(0);
            cell.setCellValue("Ukupno:");

            setFormulaToCell("SUM(F" + 3 + ":F" + (rownum - 1) + ")", row, 5);

            pt.drawBorders(new CellRangeAddress(rownum, rownum, 0, 5),
                    BorderStyle.THIN, BorderExtent.ALL);
            pt.applyBorders(sheet);

            defaultSetCellOfRow(sheet.getRow(rownum), workbook, IndexedColors.GREY_25_PERCENT.getIndex(), FillPatternType.ALT_BARS,
                    IndexedColors.WHITE.getIndex(), true);

            setColumnAutoSize(sheet, columnNames.length);

            FileOutputStream out = new FileOutputStream(new File(path + ".xlsx"));
            workbook.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createCellsClient(Klijent klijent, Row row, int i) {
        Cell cell = row.createCell(0);
        cell.setCellValue(i);

        cell = row.createCell(1);
        cell.setCellValue(klijent.getSifraKlijenta());

        cell = row.createCell(2);
        cell.setCellValue(klijent.getImeKlijenta());

        cell = row.createCell(3);
        cell.setCellValue(klijent.getPrezimeKlijenta());

        cell = row.createCell(4);
        cell.setCellValue(klijent.getBrojPoseta());

        cell = row.createCell(5);
        cell.setCellValue(Double.parseDouble(klijent.getDug() + ""));
    }
}
