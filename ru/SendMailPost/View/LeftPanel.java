package SendMailPost.View;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    GridBagConstraints containLeft;
    JTable table;
    JScrollPane scrollPane;
    JTextArea textArea;
    JComboBox box;
    String [] selector = {"Все", "Юридические лица", "Физические лица","Действующие обьекты", "Клиенты в архиве"};

    public LeftPanel( Object[][] data, String[] columnName) {

        //splitPane.setOneTouchExpandable(true);
        //splitPane.setDividerLocation(50);
        setLayout(new GridBagLayout());
        containLeft = new GridBagConstraints();

        textArea = new JTextArea("Произвольный текст");
        containLeft.fill = GridBagConstraints.HORIZONTAL;
        containLeft.weightx = 0.5;
        containLeft.gridx = 1;
        containLeft.gridy = 0;
        add(textArea, containLeft);

        box = new JComboBox(selector);
        containLeft.fill = GridBagConstraints.HORIZONTAL;
        containLeft.weightx = 0.5;
        containLeft.gridx = 3;
        containLeft.gridy = 0;
        add(box, containLeft);

        table = new JTable(data, columnName);
        scrollPane = new JScrollPane(table);
        containLeft.fill = GridBagConstraints.BOTH;
        containLeft.ipady = 0;
        containLeft.weighty = 0.5;
        containLeft.anchor = GridBagConstraints.PAGE_END; //bottom of space
        containLeft.insets = new Insets(10, 0, 0, 0);  //top padding

        containLeft.gridx = 0;
        containLeft.gridwidth = 4;
        containLeft.gridy = 2;
        add(scrollPane, containLeft);

    }

}
