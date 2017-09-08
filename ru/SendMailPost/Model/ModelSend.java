package ru.SendMailPost.Model;

import ru.SendMailPost.Controller.ConnectFirebird;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelSend {
    public String getQuery() {
        return query;
    }

    public ModelSend(String query) {
        this.query = query;
    }

    public void setQuery(String query) {
        this.query = query;
    }


    public Object[][] getQueryData(String query) throws SQLException {
        List<Object[]> listData = new ArrayList<Object[]>();
        ConnectFirebird conFirebird = new ConnectFirebird();
        Statement statement = conFirebird.getConnect().createStatement();
        ResultSet result = statement.executeQuery(query); //Запрос к БД передаётся черес переменную query
        ResultSetMetaData resultMetaData = result.getMetaData();
        int colCount = resultMetaData.getColumnCount();
        while (result.next()){
            Object [] rowData = new Object[colCount];
            for (int i = 1; i <= colCount; i++){
                rowData[i - 1] = result.getObject(i);
            }
            listData.add(rowData);
        }
        queryData = listData.toArray(new Object[listData.size()][colCount]);
        //conFirebird.close();
        return queryData;
    }

    private String query;
    Object queryData [][];



}
