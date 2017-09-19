package SendMailPost.View;

import SendMailPost.Controller.SelectAll;

import javax.swing.*;
import java.sql.SQLException;

public class FormSend extends JFrame {


    private JMenuBar mainMenu;
    private JMenu menu, newMenu;
    private JMenuItem itemMenu;
    private JSplitPane splitPane;
    private LeftPanel leftPanal;
    private RightPanel rightPanel;
    //private JTextArea textArea;

    public static class DataForForm {
        static SelectAll selectAll= new SelectAll();
         static String[] columnName = selectAll.getColumnNameSelectData();
         static Object[][] data= selectAll.getSelectData();

        public void setColumnName(String[] columnName) {
            this.columnName = columnName;
        }

        public void setData(Object[][] data) {
            this.data = data;
        }
    }
    public FormSend() throws SQLException {

        super("Учебный проект");
        //setLayout(gbl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        mainMenu = new JMenuBar();
        menu = new JMenu("File");
        newMenu = new JMenu("New File");
        leftPanal = new LeftPanel(DataForForm.data, DataForForm.columnName);
        rightPanel = new RightPanel(DataForForm.data, DataForForm.columnName);
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
        //textArea = new JTextArea("Произвольный текст");

    }

    public static void main(String[] args) throws SQLException {
        FormSend formSend = new FormSend();
        formSend.pack();
        formSend.setVisible(true);

    }

}
