/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private List<Radnik> radnici;
    private String[] columnNames;
    private ResourceBundle resourceBundle;

    public TableModelEmployees(List<Radnik> radnici) {
        this.radnici = radnici;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{resourceBundle.getString("column_id_employee"),
            resourceBundle.getString("column_first_name"), resourceBundle.getString("column_last_name"),
            resourceBundle.getString("column_address"), resourceBundle.getString("column_phone"),
            resourceBundle.getString("column_idnumber"), resourceBundle.getString("column_administrator")};
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

    public void updateTable(List<Radnik> radnici) {
        this.radnici = radnici;
        fireTableDataChanged();
    }
}
