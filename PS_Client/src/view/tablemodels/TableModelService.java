package view.tablemodels;

import controller.Controller;
import domain.Usluga;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelService extends AbstractTableModel {

    /**
     * List of data which represented in table.
     */
    private List<Usluga> usluge;

    /**
     * Array of strings that represents names of columns.
     */
    private final String[] columnNames;

    /**
     * Reference of resource bundle as dictionary.
     */
    private final ResourceBundle resourceBundle;

    public TableModelService(List<Usluga> usluge) {
        this.usluge = usluge;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_service_id"), resourceBundle.getString("column_service_name"),
            resourceBundle.getString("column_service_description"), resourceBundle.getString("column_service_price"),
            resourceBundle.getString("column_service_price_with_tax"), resourceBundle.getString("column_service_tax")};
    }

    @Override
    public int getRowCount() {
        return usluge.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usluga usluga = usluge.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return usluga.getSifraUsluge();
            case 1:
                return usluga.getNazivUsluge();
            case 2:
                return usluga.getOpisUsluge();
            case 3:
                return usluga.getPredmetProdaje().getCena();
            case 4:
                return usluga.getPredmetProdaje().getCenaSaPorezom();
            case 5:
                return usluga.getPredmetProdaje().getPoreskaStopa().toString();
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
     * @param usluge is updated list of data for table.
     */
    public void updateTable(List<Usluga> usluge) {
        this.usluge = usluge;
        fireTableDataChanged();
    }

}
