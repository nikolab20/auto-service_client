package view.tablemodels;

import controller.Controller;
import domain.Klijent;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelCustomers extends AbstractTableModel {

    /**
     * List of data which represented in table.
     */
    private List<Klijent> klijenti;

    /**
     * Array of strings that represents names of columns.
     */
    private final String[] columnNames;

    /**
     * Reference of resource bundle as dictionary.
     */
    private final ResourceBundle resourceBundle;

    public TableModelCustomers(List<Klijent> klijenti) {
        this.klijenti = klijenti;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{resourceBundle.getString("column_customer_id_client"),
            resourceBundle.getString("column_customer_first_name"), resourceBundle.getString("column_customer_last_name"),
            resourceBundle.getString("column_customer_num_of_visits"), resourceBundle.getString("column_customer_debt")};
    }

    @Override
    public int getRowCount() {
        return klijenti.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent klijent = klijenti.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return klijent.getSifraKlijenta();
            case 1:
                return klijent.getImeKlijenta();
            case 2:
                return klijent.getPrezimeKlijenta();
            case 3:
                return klijent.getBrojPoseta();
            case 4:
                return klijent.getDug();
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
     * @param klijenti is updated list of data for table.
     */
    public void updateTable(List<Klijent> klijenti) {
        this.klijenti = klijenti;
        fireTableDataChanged();
    }

}
