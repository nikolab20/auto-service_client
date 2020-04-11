/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private List<Deo> delovi;
    private String[] columnNames;
    private ResourceBundle resourceBundle;

    public TableModelCarPart(List<Deo> delovi) {
        this.delovi = delovi;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_serial_number"), resourceBundle.getString("column_name"),
            resourceBundle.getString("column_manufacturer"), resourceBundle.getString("column_description"),
            resourceBundle.getString("column_stock"), resourceBundle.getString("column_price"),
            resourceBundle.getString("column_price_with_tax"), resourceBundle.getString("column_tax")};
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

    public void updateTable(List<Deo> delovi) {
        this.delovi = delovi;
        fireTableDataChanged();
    }

}
