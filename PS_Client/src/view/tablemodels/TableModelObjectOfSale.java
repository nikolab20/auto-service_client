package view.tablemodels;

import controller.Controller;
import domain.DomainObject;
import domain.PredmetProdaje;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelObjectOfSale extends AbstractTableModel {

    /**
     * List of data which represented in table.
     */
    private final Map<DomainObject, String> predmetiProdaje;

    /**
     * Array of strings that represents names of columns.
     */
    private final String[] columnNames;

    /**
     * Reference of resource bundle as dictionary.
     */
    private final ResourceBundle resourceBundle;

    /**
     * A tranformed map to array.
     */
    private Object[][] data;

    public TableModelObjectOfSale(Map<DomainObject, String> predmetiProdaje) {
        this.predmetiProdaje = predmetiProdaje;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_sale_id_object_of_sale"), resourceBundle.getString("column_sale_price"),
            resourceBundle.getString("column_sale_price_with_tax"), resourceBundle.getString("column_sale_tax"),
            resourceBundle.getString("column_sale_name")};
    }

    @Override
    public int getRowCount() {
        return predmetiProdaje.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data == null) {
            data = repack();
        }

        Object[] niz = data[rowIndex];

        switch (columnIndex) {
            case 0:
                return niz[columnIndex];
            case 1:
                return niz[columnIndex];
            case 2:
                return niz[columnIndex];
            case 3:
                return niz[columnIndex];
            case 4:
                return niz[columnIndex];
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * A method for transforming map to array.
     *
     * @return a repacked map to array.
     */
    public Object[][] repack() {
        Object niz[][] = new Object[predmetiProdaje.keySet().size()][columnNames.length];

        int index = 0;
        for (DomainObject key : predmetiProdaje.keySet()) {
            PredmetProdaje predmetProdaje = (PredmetProdaje) key;
            niz[index][0] = predmetProdaje.getSifraPredmetaProdaje();
            niz[index][1] = predmetProdaje.getCena();
            niz[index][2] = predmetProdaje.getCenaSaPorezom();
            niz[index][3] = predmetProdaje.getPoreskaStopa();
            niz[index][4] = predmetiProdaje.get(key);
            index++;
        }

        return niz;
    }
}
