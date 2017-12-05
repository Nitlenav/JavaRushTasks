package SendMailPost.Controller;


import SendMailPost.ConnectingMailboxSendingMail.Mail;
import SendMailPost.ConnectingMailboxSendingMail.SendMail;
import SendMailPost.ConnectingMailboxSendingMail.TextMessag;
import SendMailPost.Model.ModelData;

import javax.mail.MessagingException;
import javax.swing.*;
import java.io.UnsupportedEncodingException;

/**
 * Класс для циклической рассылки почты
 */
public class CyclicDeliveryLetters  {

    private final static CyclicDeliveryLetters cyclicDeliveryLetters = new CyclicDeliveryLetters();
    private Object[][] data;            //Масив данных с запроса к БД
    private String[] columnName;        //Название колонок
    private String code;                //Бух код клиента
    private String firmName;            //Название клиента
    private String[] emailAddres;       //Электронный адрес клиента
    private TextMessag textMessag = new TextMessag();               //Текст сообщения и название письма
    private Mail mail;     //Элктронный адрес отправителя, получателя и место расположения файлов для рассылки
    private FindFileInPath fileInPath;
    private SendMail sendMail = new SendMail();
    private int valProgressBar = 0;
    private ProgressBar progress = new ProgressBar();

    private CyclicDeliveryLetters() {
    }

    public static CyclicDeliveryLetters getCyclicDeliveryLetters() {
        return cyclicDeliveryLetters;
    }

    public void setData(ModelData modelData) {
        this.columnName = modelData.getColumnNameSelectData();
        this.data = modelData.getSelectData();
    }

    public Object[][] getData() {
        return data;
    }

    public ProgressBar getProgress() {
        return progress;
    }

    public void prorperti(int val){
        if (SwingUtilities.isEventDispatchThread()){

        } else {
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    progress.setValue(val);
                }
            });
        }
    }

    public void sendingMessages() throws UnsupportedEncodingException, MessagingException {

        String path[];
        String adres;
        for (Object[] o : data) {
            valProgressBar++;
            System.out.println(valProgressBar);
            prorperti(valProgressBar);
            code = String.valueOf(o[0]);
            firmName = String.valueOf(o[1]);
            if (String.valueOf(o[2]).contains("@")) {
                adres = String.valueOf(o[2]).replaceAll(",", " ");
                emailAddres = adres.split(" ");
            }
            textMessag.setFirmName(firmName);
            mail = new Mail();
            fileInPath = new FindFileInPath(code, TextAndArea.paht);
            //масив электронных адресов
            path = fileInPath.getPathFile().toArray(new String[fileInPath.getPathFile().size()]);
            //System.out.println(minValProgressBar);
            //внести проверку на наличие электронных адресов.
            if (path.length > 0) {
                //вводим Емеил для рассылки
                mail.setEmailRecipient(emailAddres);
                //System.out.println(code);
                // Путь к файлу рассылки.
                mail.setLocation(path);
                sendMail.setInitializingData(textMessag, mail);
                sendMail.sendMessage();
            }
        }
    }
}
