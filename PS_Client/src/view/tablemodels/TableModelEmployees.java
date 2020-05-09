package view.tablemodels;

import controller.Controller;
import domain.Radnik;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelEmployees extends AbstractTableModel {

    /**
     * List of data which represented in table.
     */
    private List<Radnik> radnici;

    /**
     * Array of strings that represents names of columns.
     */
    private final String[] columnNames;

    /**
     * Reference of resource bundle as dictionary.
     */
    private final ResourceBundle resourceBundle;

    public TableModelEmployees(List<Radnik> radnici) {
        this.radnici = radnici;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{resourceBundle.getString("column_employee_id_employee"),
            resourceBundle.getString("column_employee_first_name"), resourceBundle.getString("column_employee_last_name"),
            resourceBundle.getString("column_employee_address"), resourceBundle.getString("column_employee_phone"),
            resourceBundle.getString("column_employee_id_number"), resourceBundle.getString("column_employee_administrator")};
    }

    @Override
    public int getRowCount() {
        return radnici.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Radnik radnik = radnici.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return radnik.getSifraRadnika();
            case 1:
                return radnik.getImeRadnika();
            case 2:
                return radnik.getPrezimeRadnika();
            case 3:
                return radnik.getAdresa();
            case 4:
                return radnik.getTelefon();
            case 5:
                return radnik.getJMBG();
            case 6:
                return radnik.isAdministrator();
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
     * @param radnici is updated list of data for table.
     */
    public void updateTable(List<Radnik> radnici) {
        this.radnici = radnici;
        fireTableDataChanged();
    }
}
