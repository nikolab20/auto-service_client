/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tablemodels;

import controller.Controller;
import domain.DomainObject;
import domain.PredmetProdaje;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelObjectOfSale extends AbstractTableModel {

    private final Map<DomainObject, String> predmetiProdaje;
    private final String[] columnNames;
    private final ResourceBundle resourceBundle;
    private Object[][] data;

    public TableModelObjectOfSale(Map<DomainObject, String> predmetiProdaje) {
        this.predmetiProdaje = predmetiProdaje;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_id_object_of_sale"), resourceBundle.getString("column_price"),
            resourceBundle.getString("column_price_with_tax"), resourceBundle.getString("column_tax"),
            resourceBundle.getString("column_name")};
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
