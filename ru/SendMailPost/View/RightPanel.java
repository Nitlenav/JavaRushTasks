package SendMailPost.View;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

public RightPanel(Object[][] data , String [] columnName)
    {

        gridBagLeft = new GridBagLayout();
        setLayout(gridBagLeft);

        containRight = new GridBagConstraints();
        ((GridBagLayout)getLayout()).columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0};

        pathToFile = new JTextArea("Путь к файлу рассылки");
        add(pathToFile,
                new GridBagConstraints(0,0,6,1,0.5,0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0,0));
//        containRight.fill = GridBagConstraints.HORIZONTAL;
//        containRight.anchor = GridBagConstraints.CENTER;
//        containRight.gridx = 0;
//        containRight.gridy = 0;
//        containRight.gridwidth = 6;
//        containRight.weightx = 0.5;
//        add(pathToFile, containRight);


        pathSelection = new JButton("Путь к файлу");
        add(pathSelection,
                new GridBagConstraints(6,0,2,1,0.5,0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0,0));

        sendingFile = new JButton("Отправка");
        add(sendingFile,
                new GridBagConstraints(0,1,2,1,0.5,0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0,0));

        progressImplementation = new JProgressBar();
        progressImplementation.setStringPainted(true);
        progressImplementation.setMinimum(0);
        progressImplementation.setMaximum(100);
        progressImplementation.setValue(100);
        add(progressImplementation,
                new GridBagConstraints(2,1,6,1,0.5,0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0,0));

        tableOrganizations = new JTable(data, columnName);
        scrollOrganizations = new JScrollPane(tableOrganizations);
        add(scrollOrganizations,
                new GridBagConstraints(0,2,8,1,0.0,0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0,0,0,0), 0,40));
        //add(scrollOrganizations, containRight);

        labelSend = new JLabel("Отправлено");
        add(labelSend,
                new GridBagConstraints(0,3,1,1,1.0,0.0,
                        GridBagConstraints.LAST_LINE_START , GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0,0));

        countSend = new JTextArea("1000");
        add(countSend,
                new GridBagConstraints(1,3,1,1,1.0,0.0,
                        GridBagConstraints. LAST_LINE_START , GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0,0));

        labelDontSend = new JLabel("Не отправлено");
        add(labelDontSend,
                new GridBagConstraints(3,3,1,1,1.0,0.0,
                        GridBagConstraints. PAGE_END , GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0,0));

        countDontSend = new JTextArea("1000");
        add(countDontSend,
                new GridBagConstraints(4,3,1,1,1.0,0.0,
                        GridBagConstraints. PAGE_END , GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0), 0,0));

    }
    GridBagConstraints containRight;
    GridBagLayout gridBagLeft;
    JButton pathSelection;
    JButton sendingFile;
    JProgressBar progressImplementation;
    JScrollPane scrollOrganizations;
    JTable tableOrganizations;
    JTextArea pathToFile;

    JLabel labelSend;
    JTextArea countSend;
    JLabel labelDontSend;
    JTextArea countDontSend;


}
