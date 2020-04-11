/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tablemodels;

import controller.Controller;
import domain.Racun;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nikol
 */
public class TableModelBill extends AbstractTableModel {

    private List<Racun> racuni;
    private String[] columnNames;
    private ResourceBundle resourceBundle;

    public TableModelBill(List<Racun> racuni) {
        this.racuni = racuni;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_bill_id"), resourceBundle.getString("column_bill_date"),
            resourceBundle.getString("column_bill_total_price"), resourceBundle.getString("column_bill_total_price_with_tax"),
            resourceBundle.getString("column_bill_processed"), resourceBundle.getString("column_bill_ivalidated"),
            resourceBundle.getString("column_bill_worker_id"), resourceBundle.getString("column_bill_customer_id")};
    }

    @Override
    public int getRowCount() {
        return racuni.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun racun = racuni.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return racun.getBrojRacuna();
            case 1:
                return racun.getDatumIzdavanja();
            case 2:
                return racun.getUkupnaVrednost();
            case 3:
                return racun.getUkupnaVrednostSaPorezom();
            case 4:
                return racun.isObradjen();
            case 5:
                return racun.isStorniran();
            case 6:
                return racun.getRadnik().getSifraRadnika();
            case 7:
                return racun.getKlijent().getSifraKlijenta();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void updateTable(List<Racun> racuni) {
        this.racuni = racuni;
        fireTableDataChanged();
    }

}
