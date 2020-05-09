package view.tablemodels;

import controller.Controller;
import domain.Deo;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelCarPart extends AbstractTableModel {

    /**
     * List of data which represented in table.
     */
    private List<Deo> delovi;

    /**
     * Array of strings that represents names of columns.
     */
    private final String[] columnNames;

    /**
     * Reference of resource bundle as dictionary.
     */
    private final ResourceBundle resourceBundle;

    public TableModelCarPart(List<Deo> delovi) {
        this.delovi = delovi;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_part_serial_number"), resourceBundle.getString("column_part_name"),
            resourceBundle.getString("column_part_manufacturer"), resourceBundle.getString("column_part_description"),
            resourceBundle.getString("column_part_stock"), resourceBundle.getString("column_part_price"),
            resourceBundle.getString("column_part_price_with_tax"), resourceBundle.getString("column_part_tax")};
    }

    @Override
    public int getRowCount() {
        return delovi.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Deo deo = delovi.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return deo.getSerijskiBroj();
            case 1:
                return deo.getNazivDela();
            case 2:
                return deo.getProizvodjac();
            case 3:
                return deo.getOpis();
            case 4:
                return deo.getStanje();
            case 5:
                return deo.getPredmetProdaje().getCena();
            case 6:
                return deo.getPredmetProdaje().getCenaSaPorezom();
            case 7:
                return deo.getPredmetProdaje().getPoreskaStopa().toString();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Method for updating data into a table.
     *
     * @param delovi is updated list of data for table.
     */
    public void updateTable(List<Deo> delovi) {
        this.delovi = delovi;
        fireTableDataChanged();
    }

}
