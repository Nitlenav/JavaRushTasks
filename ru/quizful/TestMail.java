package quizful;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class TestMail {
    static final String ENCODING = "UTF-8";             //Перевод в кодировку
    static final String SMTPHOST = "cent.telefonet.ru"; //Соединение
    static final String SMTPPORT = "25";                //Порт подключения

    public static void main(String args[]) throws MessagingException, UnsupportedEncodingException {

        String subject = Messag.messageHeader;         //Заголовок письма
        String content = Messag.textMessage;           //Тело письма
        String addressFrom = Mail.emailSender;  //Почта отправителя
        String [] addressTo = Mail.emailRecipient; //Почта получчателя
        String login="lav@tn.local";    //Логин для подключения
        String password="159753";       //Пароль для подключения
        String [] attachment = Mail.location; //место хранения файла
        sendMultiMessage(login, password, addressFrom, addressTo, content, subject, attachment );
    }

    public static void sendMultiMessage(String login, String password, String from, String [] to, String content, String subject, String [] attachment) throws MessagingException, UnsupportedEncodingException {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", SMTPHOST);
        props.put("mail.smtp.port", SMTPPORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.mime.charset", ENCODING);

        Authenticator auth = new MyAuthenticator(login, password);
        Session session = Session.getDefaultInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        for (int i = 0; i < to.length; i++) {

            msg.setFrom(new InternetAddress(from)); //вводится почта отправителя
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));  //вводится почта получателя
            msg.setSubject(subject, ENCODING);

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, "text/plain; charset=" + ENCODING + "");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            for (int a = 0; a < attachment.length; a++) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachment[a]); //передаётся адрес хранения файла

                attachmentBodyPart.setDataHandler(new DataHandler(source));
                attachmentBodyPart.setFileName(MimeUtility.encodeText(source.getName()));

                multipart.addBodyPart(attachmentBodyPart);
            }
            msg.setContent(multipart);
            Transport.send(msg);
        }
    }
}