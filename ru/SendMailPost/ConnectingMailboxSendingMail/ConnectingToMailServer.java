package SendMailPost.ConnectingMailboxSendingMail;

import javax.mail.Session;
import java.util.Properties;

/**
 * Класс для подключения к почтовому серверу
 */
public class ConnectingToMailServer {
    private static final String ENCODING = "UTF-8";             //Перевод в кодировку
    private static final String SMTPHOST = "cent.telefonet.ru"; //Соединение
    private static final String SMTPPORT = "25";                //Порт подключения
    private static final String LOGIN = "lav@tn.local";                     //Логин для подключения
    private static final String PASSWORD = "159753";                        //Пароль для подключения
    private static Session session = getSessionConnectionPost(LOGIN, PASSWORD);

    private static Session getSessionConnectionPost(String login, String password) {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", SMTPHOST);
        props.put("mail.smtp.port", SMTPPORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.mime.charset", ENCODING);
        AuthenticationMailPost auth = new AuthenticationMailPost(login, password);
        Session session = Session.getDefaultInstance(props, auth);
        return session;
    }

    public static Session getSession() {
        return session;
    }

    public static String getENCODING() {
        return ENCODING;
    }
}
