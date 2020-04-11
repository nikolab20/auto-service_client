/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TabelModelBillItem extends AbstractTableModel {

    private List<StavkaRacuna> stavkeRacuna;
    private String[] columnNames;
    private ResourceBundle resourceBundle;

    public TabelModelBillItem(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
        resourceBundle = ResourceBundle.getBundle("props/LanguageBundle", Controller.getInstance().getLocale());
        this.columnNames = new String[]{
            resourceBundle.getString("column_id_bill"), resourceBundle.getString("column_number"),
            resourceBundle.getString("column_amount"), resourceBundle.getString("column_total_price"),
            resourceBundle.getString("column_total_price_with_tax"), resourceBundle.getString("column_measurement_unit"),
            resourceBundle.getString("column_id_object_of_sale")};
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

    public void updateTable(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
        fireTableDataChanged();
    }

}
