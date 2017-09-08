package ru.SendMailPost.View;

import javax.swing.*;
import java.awt.*;

public class FormSend extends JFrame {


    JMenuBar mainMenu;
    JMenu menu, newMenu;
    JMenuItem itemMenu;
    JSplitPane splitPane;
    JPanel leftPanal = new JPanel();
    //JPanel rightPanal = new JPanel();
    GridBagConstraints containLeft;
    GridBagConstraints containRight;

    JTable table;
    JScrollPane scrollPane;



    JTextArea textArea;
    JComboBox box;
    String [] selector = {"Все", "Юридические лица", "Физические лица", "Клиенты в архиве"};
    String [] columnName = {"Бух код", "Название клиента"};
    Object[][] data = {
            {new Integer(1), "Snowboarding"},
            {new Integer(2), "John"},
            {new Integer(3),"Sue"},
            {new Integer(4),"Jane"},
            {new Integer(5),"Joe"},
            {new Integer(1), "Snowboarding"},
            {new Integer(2), "John"},
            {new Integer(3),"Sue"},
            {new Integer(4),"Jane"},
            {new Integer(5),"Joe"}

    };

    public FormSend() {

        super("Учебный проект");
        //setLayout(gbl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainMenu = new JMenuBar();
        menu = new JMenu("File");
        newMenu = new JMenu("New File");

        newMenu.add(new JMenuItem("add"));
        menu.add(newMenu);
        itemMenu = new JMenuItem("Close");
        menu.add(itemMenu);
        menu.add(new JMenuItem("Open"));
        menu.add(new JMenuItem("Close All"));
        mainMenu.add(menu);
        setJMenuBar(mainMenu);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        //splitPane.setOneTouchExpandable(true);
        //splitPane.setDividerLocation(50);
        leftPanal.setLayout(new GridBagLayout());
//        ((GridBagLayout)leftPanal.getLayout()).columnWidths = new int[] {40, 40, 40, 40, 40, 40, 40, 40};
//        ((GridBagLayout)leftPanal.getLayout()).rowHeights = new int[] {0, 0, 0};
//        ((GridBagLayout)leftPanal.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
//        ((GridBagLayout)leftPanal.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0};

        containLeft = new GridBagConstraints();
        splitPane.setResizeWeight(0.5);
        splitPane.setTopComponent(leftPanal);

        RightPanel rightPanel = new RightPanel(data, columnName);
        //rightPanel.containRight.anchor = GridBagConstraints.PAGE_START;

        splitPane.setRightComponent(rightPanel);
        add(splitPane);

        textArea = new JTextArea("Произвольный текст");
        containLeft.fill = GridBagConstraints.HORIZONTAL;
        //containLeft.anchor = GridBagConstraints.PAGE_START;
        containLeft.weightx = 0.5;
        containLeft.gridx = 1;
        containLeft.gridy = 0;
        leftPanal.add(textArea, containLeft);

        box = new JComboBox(selector);
        containLeft.fill = GridBagConstraints.HORIZONTAL;
        containLeft.weightx = 0.5;
        containLeft.gridx = 3;
        containLeft.gridy = 0;
        leftPanal.add(box, containLeft);


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
        leftPanal.add(scrollPane, containLeft);

    }

    public static void main(String[] args) {
        FormSend formSend = new FormSend();
        formSend.pack();
        formSend.setVisible(true);

    }

}
