package SendMailPost.Controller;

import SendMailPost.Model.ModelData;

import javax.swing.table.AbstractTableModel;

public class FirstColumnTableModel extends AbstractTableModel {

    public FirstColumnTableModel() {
    }
    public FirstColumnTableModel(ModelData modelData) {
        data = modelData.getSelectData();
        columnName = modelData.getColumnNameSelectData();
    }
    // Методы
    public int getRowCount(){return data.length;}
    public int getColumnCount(){return data[0].length;}
    public Object getValueAt(int row, int col){return data[row][col];}
    public String getColumnName(int column) {return columnName[column];}

    public Object[][] getData() {
        return data;
    }

    public String[] getColumnName() {
        return columnName;
    }


    private Object[][] data;
    private String[] columnName;

}
