package SendMailPost.Controller;


import SendMailPost.ConnectingMailboxSendingMail.SendMail;
import SendMailPost.ConnectingMailboxSendingMail.TextMessag;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class TextAndField extends JTextField { //Текстовое поле заголовка письма
    public TextAndField() {
        super(new TextMessag().getMessageHeader());
        setBorder(new TitledBorder("Заголовок письма"));
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                System.out.println(getText());

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Update");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Remout");
            }
        });
    }
}
