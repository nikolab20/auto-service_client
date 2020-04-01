/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TableModelClients extends AbstractTableModel {

    private List<Klijent> klijenti;
    private String[] columnNames;
    private ResourceBundle resourceBundle;

    public TableModelClients(List<Klijent> klijenti) {
        this.klijenti = klijenti;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{resourceBundle.getString("column_id_client"),
            resourceBundle.getString("column_first_name"), resourceBundle.getString("column_last_name"),
            resourceBundle.getString("column_num_of_visits"), resourceBundle.getString("column_debt")};
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

    public void updateTable(List<Klijent> klijenti) {
        this.klijenti = klijenti;
        fireTableDataChanged();
    }

}
