package Practic_JAVA.StudentManeger;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionsDb {
    private static java.sql.Connection connection = null;
    private static Statement statement = null;

    public static void Conect () throws ClassNotFoundException, SQLException {

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");


    }




}
