package SendMailPost.Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelSend {

    private String query;
    private Object queryData [][];

    private List<Object[]> listData = new ArrayList<Object[]>();
    private ConnectFirebird conFirebird = new ConnectFirebird();


    public String getQuery() {
        return query;
    }

    public ModelSend(String query) throws SQLException {
        this.query = query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public  Object[][] getQueryData() throws SQLException {
        //Запрос к БД передаётся черес переменную query
        Statement statement = conFirebird.getConnect().createStatement();
        ResultSet result = statement.executeQuery(query);
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
        conFirebird.close();
        return queryData;
    }
}
