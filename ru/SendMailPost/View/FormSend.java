package SendMailPost.View;

import SendMailPost.Controller.CyclicDeliveryLetters;
import SendMailPost.Model.SelectAll;

import javax.swing.*;
import java.sql.SQLException;

public class FormSend extends JFrame {  //Форма которая собирает все панели.

    private JSplitPane splitPane;
    private LeftPanel leftPanal;
    private RightPanel rightPanel;

    public static class DataForForm {
        static SelectAll selectAll = new SelectAll();
        static String[] columnName = selectAll.getColumnNameSelectData();
        static Object[][] data = selectAll.getSelectData();

        public void setColumnName(String[] columnName) {
            this.columnName = columnName;
        }

        public void setData(Object[][] data) {
            this.data = data;
        }
    }

    public FormSend() throws SQLException, InterruptedException {
        super("Учебный проект");
        //setLayout(gbl);
        setSize(800, 600);
        setLocationRelativeTo(null);

        leftPanal = new LeftPanel(DataForForm.data, DataForForm.columnName);
        rightPanel = new RightPanel(DataForForm.data, DataForForm.columnName);
        setJMenuBar(new MainMenu());

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        //splitPane.setOneTouchExpandable(true);
        //splitPane.setDividerLocation(50);
        splitPane.setResizeWeight(0.5);
        splitPane.setTopComponent(leftPanal);
        splitPane.setRightComponent(rightPanel);
        add(splitPane);

    }

    public static void main(String[] args) throws SQLException, InterruptedException {
        JFrame formSend = new FormSend();
        formSend.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formSend.pack();
        formSend.setVisible(true);
//        for(int i = 0 ; i < 10; i++) {
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    int numVal = CyclicDeliveryLetters.getCyclicDeliveryLetters().getValProgressBar();
//                    rightPanel.getProgressImplementation().setValue(numVal);
//                }
//            });
//        }
        //RightPanel.progressImplementation.setMaximum(CyclicDeliveryLetters.getCyclicDeliveryLetters().getData().length);
        //RightPanel.progressImplementation.setValue(CyclicDeliveryLetters.getCyclicDeliveryLetters().getMinValProgressBar());
        //System.out.println(CyclicDeliveryLetters.getCyclicDeliveryLetters().getvalProgressBar());
    }
}
