package SendMailPost.ConnectingMailboxSendingMail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;

/**
 * Класс для рассылки писем с почтового сервера
 */
public class SendMail {

    private String subject;         //Заголовок письма
    private String content;           //Тело письма
    private String addressFrom;             //Почта отправителя
    private String[] addressTo;          //Почта получчателя
    private String[] attachment;               //место хранения файла

    public void setInitializingData(TextMessag textMessag, Mail mail) {
this.subject = textMessag.getMessageHeader() + " " + textMessag.getFirmName();//Заголовок письма
        this.content = textMessag.getTextMessage();          //Тело письма
        this.addressFrom = mail.getEmailSender();            //Почта отправителя
        this.addressTo = mail.getEmailRecipient();           //Почта получчателя
        this.attachment = mail.getLocation();                //Место расположения файла
    }
    public void sendMessage() throws MessagingException, UnsupportedEncodingException {
        MimeMessage msg = new MimeMessage(ConnectingToMailServer.getSession());
        if (this.addressTo != null) {
            for (int i = 0; i < this.addressTo.length; i++) {
                if (this.addressTo[i].matches("[А-Яа-яA-Za-z0-9]+(\\.[А-Яа-яA-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@[_А-Яа-яA-Za-z0-9\\-]+.[А-Яа-яA-Za-z]{2,}")) {
                    msg.setFrom(new InternetAddress(this.addressFrom));      //вводится почта отправителя
                    //msg.setRecipient(Message.RecipientType.TO, new InternetAddress(this.addressTo[i]));    //вводится почта получателя
                    msg.setRecipient(Message.RecipientType.TO, new InternetAddress("lav@telefonet.ru"));
                    msg.setSubject(subject, ConnectingToMailServer.getENCODING());                         //прекодировка текста.
                    BodyPart messageBodyPart = new MimeBodyPart();
                    messageBodyPart.setContent(content, "text/plain; charset=" + ConnectingToMailServer.getENCODING() + "");
                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(messageBodyPart);
                    if (attachment.length > 0) {
                        for (int a = 0; a < attachment.length; a++) {
                            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                            DataSource source = new FileDataSource(attachment[a]); //передаётся адрес хранения файла
                            attachmentBodyPart.setDataHandler(new DataHandler(source));
                            attachmentBodyPart.setFileName(MimeUtility.encodeText(source.getName()));
                            multipart.addBodyPart(attachmentBodyPart);
                        }
                    }
                    msg.setContent(multipart);
                    Transport.send(msg);
                }
            }
        }
    }
}
