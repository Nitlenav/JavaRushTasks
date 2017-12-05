package SendMailPost.ConnectingMailboxSendingMail;

public class TextMessag {

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getFirmName() {
        return firmName;
    }

    private String firmName = "";

    private String messageHeader = "Счёт для";

    private String textMessage = new String("Компания Теленет благоддарит Вас за сотрудничество \n" +
            "Внимание!!! Это автоматическая рассылка, не требующая ответа.\n" +
            "\n" +
            "Документы находятся в прикреплённых файлах\n" +
            "По все вопросам обращаться по тел. +7-495-777-23-33\n" +
            "или по электронному адресу: kgi@telefonet.ru");
}
