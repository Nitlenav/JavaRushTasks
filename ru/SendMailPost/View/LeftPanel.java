package SendMailPost.View;

import SendMailPost.Controller.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel {

    private GridBagConstraints containLeft;
    private JTable table;
    private JScrollPane scrollPane;
    //JTextArea textArea;
    private TextAndArea textArea;
    private JComboBox box;
    //ModelData modelData;
    private String [] selector = {"Все", "Юридические лица", "Физические лица","Действующие обьекты"};

    public JTable getTable() {
        return table;
    }

    public LeftPanel() {}
    public LeftPanel(Object[][] data, String[] columnName) {

        //splitPane.setOneTouchExpandable(true);
        //splitPane.setDividerLocation(50);
        setLayout(new GridBagLayout());
        containLeft = new GridBagConstraints();

        //textArea = new JTextArea("Произвольный текст");
        textArea = new TextAndArea();
        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String [] word = textArea.getText().split("\\W+");
                if (word.length > 0){
                    //TableModel model = new LeftPanel().getTable().getModel();
                    for (String s : word){

                    }
                }
            }
        });
        containLeft.fill = GridBagConstraints.HORIZONTAL;
        containLeft.weightx = 0.5;
        containLeft.gridx = 1;
        containLeft.gridy = 0;
        add(textArea, containLeft);

        box = new JComboBox(selector);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(box.getSelectedItem().toString()){
                    case "Все":
                        table.setModel(new FirstColumnTableModel(new SelectAll()));
                        break;
                    case "Юридические лица":
                        table.setModel(new FirstColumnTableModel(new SelectActiveOrganizations()));
                        break;
                    case "Физические лица":
                        table.setModel(new FirstColumnTableModel(new SelectActivePeoples()));
                        break;
                    case "Действующие обьекты":
                        table.setModel(new FirstColumnTableModel(new ActiveObjects()));
                        break;
                }
            }
        });

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
