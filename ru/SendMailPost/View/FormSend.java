package SendMailPost.View;

import SendMailPost.Controller.Select;
import SendMailPost.Model.ModelSend;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class FormSend extends JFrame {


    JMenuBar mainMenu;
    JMenu menu, newMenu;
    JMenuItem itemMenu;
    JSplitPane splitPane;
    LeftPanel leftPanal;
    RightPanel rightPanel;
    JTextArea textArea;
    String [] columnName = {"CODE", "FIRM_NAME", "TODATE", "OBJECT", "NAME_OBJECTS", "EMAIL"};

    Object[][] data = new ModelSend(new Select().getSelectAll()).getQueryData();

    public FormSend() throws SQLException {

        super("Учебный проект");
        //setLayout(gbl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainMenu = new JMenuBar();
        menu = new JMenu("File");
        newMenu = new JMenu("New File");
        leftPanal = new LeftPanel(data, columnName);
        rightPanel = new RightPanel(data, columnName);
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
        splitPane.setResizeWeight(0.5);
        splitPane.setTopComponent(leftPanal);
        splitPane.setRightComponent(rightPanel);
        add(splitPane);
        textArea = new JTextArea("Произвольный текст");

    }

    public static void main(String[] args) throws SQLException {
        FormSend formSend = new FormSend();
        formSend.pack();
        formSend.setVisible(true);

    }

}
