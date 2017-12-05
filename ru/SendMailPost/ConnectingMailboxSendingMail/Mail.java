package SendMailPost.ConnectingMailboxSendingMail;

public class Mail {

    private String[] emailRecipient;  //Адресс получателя
    private String emailSender = new String("billing@telefonet.ru"); //Адрес отправителя
    private String[] location; //Место расположенияфайла.

    public String[] getEmailRecipient() {
        return emailRecipient;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public String[] getLocation() {
        return location;
    }

    public void setEmailRecipient(String[] emailRecipient) {
        this.emailRecipient = emailRecipient;//new String[]{"lav@telefonet.ru", "lav@tn.local"};
    }

    public void setLocation(String[] location) {
        this.location = location;
    }
}
