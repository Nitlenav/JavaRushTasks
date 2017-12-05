package SendMailPost.Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFirebird { //класс для создания подключения к БД

    static final String driver = "org.firebirdsql.jdbc.FBDriver";
    private String ip = "172.16.10.33";
    private String alias = "Telenet";
    private final String url = "jdbc:firebirdsql://"+ ip +"/"+ alias +"?encoding=utf8&amp";
    //static final String url = "jdbc:firebirdsql://172.16.10.33/test_db?encoding=utf8&amp";
    static String login = "JAVA_CLIENT";
    static String passwrd = "159753";

    private Connection connect ;

    public Connection getConnect() {
        return connect;
    }

    public ConnectFirebird(){
        try {
            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(url, login, passwrd);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close (){
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
