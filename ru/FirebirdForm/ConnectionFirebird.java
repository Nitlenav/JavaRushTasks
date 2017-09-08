package ru.FirebirdForm;

/**
 * Created by lav on 28.02.2017.
 */
/**
 * Created by lav on 28.02.2017.
 */
public class ConnectionFirebird {


    static final String driver = "org.firebirdsql.jdbc.FBDriver";
    static final String url = "jdbc:firebirdsql://172.16.10.33/test_db?encoding=utf8&amp";
    static String client = "JAVA_CLIENT";
    static String passwrd = "159753";

    static KModel model = new KModel();
    static KFDB baza = new KFDB(driver, url, client, passwrd);

}