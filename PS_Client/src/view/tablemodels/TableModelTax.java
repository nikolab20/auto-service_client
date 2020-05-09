package view.tablemodels;

import controller.Controller;
import domain.PoreskaStopa;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelTax extends AbstractTableModel {

    /**
     * List of data which represented in table.
     */
    private List<PoreskaStopa> poreskeStope;

    /**
     * Array of strings that represents names of columns.
     */
    private final String[] columnNames;

    /**
     * Reference of resource bundle as dictionary.
     */
    private final ResourceBundle resourceBundle;

    public TableModelTax(List<PoreskaStopa> poreskaStope) {
        this.poreskeStope = poreskaStope;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_tax_id"), resourceBundle.getString("column_tax_name"),
            resourceBundle.getString("column_tax_value")};
    }

    @Override
    public int getRowCount() {
        return poreskeStope.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoreskaStopa poreskaStopa = poreskeStope.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return poreskaStopa.getId();
            case 1:
                return poreskaStopa.getOznaka();
            case 2:
                return poreskaStopa.getVrednost();
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
     * @param poreskaStope is updated list of data for table.
     */
    public void updateTable(List<PoreskaStopa> poreskaStope) {
        this.poreskeStope = poreskaStope;
        fireTableDataChanged();
    }
}
