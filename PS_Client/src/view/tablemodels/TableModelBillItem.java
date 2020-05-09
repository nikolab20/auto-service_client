package view.tablemodels;

import controller.Controller;
import domain.StavkaRacuna;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelBillItem extends AbstractTableModel {

    /**
     * List of data which represented in table.
     */
    private List<StavkaRacuna> stavkeRacuna;

    /**
     * Array of strings that represents names of columns.
     */
    private final String[] columnNames;

    /**
     * Reference of resource bundle as dictionary.
     */
    private final ResourceBundle resourceBundle;
    
    public TableModelBillItem(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_bill_item_id_bill"), resourceBundle.getString("column_bill_item_number"),
            resourceBundle.getString("column_bill_item_amount"), resourceBundle.getString("column_bill_item_total_price"),
            resourceBundle.getString("column_bill_item_total_price_with_tax"), resourceBundle.getString("column_bill_item_measurement_unit"),
            resourceBundle.getString("column_bill_item_id_object_of_sale")
        };
    }
    
    @Override
    public int getRowCount() {
        return stavkeRacuna.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna stavkaRacuna = stavkeRacuna.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return stavkaRacuna.getRacun().getBrojRacuna();
            case 1:
                return stavkaRacuna.getRB();
            case 2:
                return stavkaRacuna.getKolicina();
            case 3:
                return stavkaRacuna.getUkupnaCena();
            case 4:
                return stavkaRacuna.getUkupnaCenaSaPorezom();
            case 5:
                return stavkaRacuna.getJedinicaMere();
            case 6:
                return stavkaRacuna.getPredmetProdaje().getSifraPredmetaProdaje();
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
     * @param stavkeRacuna is updated list of data for table.
     */
    public void updateTable(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
        fireTableDataChanged();
    }
    
}
