package SendMailPost.View;

import SendMailPost.ConnectingMailboxSendingMail.TextMessag;
import SendMailPost.Controller.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightPanel extends JPanel { //наполнение левой панели в программе

    public RightPanel(Object[][] data, String[] columnName) throws InterruptedException {
        gridBagLeft = new GridBagLayout();
        setLayout(gridBagLeft);

        containRight = new GridBagConstraints();
        ((GridBagLayout) getLayout()).columnWidths = new int[]{40, 40, 40, 40, 40, 40, 40, 40};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};

        pathToFile = new TextAndArea.PathToDistributionFile();
        add(pathToFile,
                new GridBagConstraints(0, 0, 6, 1, 0.5, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        pathSelection = new JButton("Путь к файлу");
        add(pathSelection,
                new GridBagConstraints(6, 0, 2, 1, 0.5, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        sendingFile = new ButtonSendingFile();
        add(sendingFile,
                new GridBagConstraints(0, 1, 2, 1, 0.5, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        progressImplementation = CyclicDeliveryLetters.getCyclicDeliveryLetters().getProgress();
//        progressImplementation.setStringPainted(true);
//        progressImplementation.setMinimum(0);
//        progressImplementation.setMaximum(100);
//        progressImplementation.setValue(100);
        add(progressImplementation,
                new GridBagConstraints(2, 1, 6, 1, 0.5, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        nameLatter = new TextAndField(); //Добавляем текст заголовка
        add(nameLatter,
                new GridBagConstraints(0, 2, 8, 1,0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        textLatter = new JTextArea(textMessag.getTextMessage()); //Добавляем текст письма
        scrollTextLatter = new JScrollPane(textLatter);
        scrollTextLatter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                        "Текст письма"),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        add(scrollTextLatter,
                new GridBagConstraints(0, 3, 8, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 300));

        labelSend = new JLabel("Отправлено");
        add(labelSend,
                new GridBagConstraints(0, 4, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        countSend = new JTextArea("1000");
        add(countSend,
                new GridBagConstraints(1, 4, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        labelDontSend = new JLabel("Не отправлено");
        add(labelDontSend,
                new GridBagConstraints(3, 4, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        countDontSend = new JTextArea("1000");
        add(countDontSend,
                new GridBagConstraints(4, 4, 1, 1, 1.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
    }

    public ProgressBar getProgressImplementation() {
        return progressImplementation;
    }


    GridBagConstraints containRight;
    GridBagLayout gridBagLeft;
    JButton pathSelection;
    ButtonSendingFile sendingFile;
    ProgressBar progressImplementation;
    JScrollPane scrollTextLatter; //Скрол письма
    TextAndArea.PathToDistributionFile pathToFile;           //Путь к файлу

    JLabel labelSend;
    JTextArea countSend;
    JLabel labelDontSend;
    JTextArea countDontSend;
    TextAndField nameLatter; //Заголовок письма
    JTextArea textLatter; //Текст письма
    private TextMessag textMessag = new TextMessag();


}
