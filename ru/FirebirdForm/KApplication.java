package ru.FirebirdForm;

/**
 * Created by lav on 28.02.2017.
 */

import javax.swing.*;
import java.awt.*;

/**
 * Created by lav on 28.02.2017.
 */

public class KApplication extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField textField = new JTextField();
    private JPanel panel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    JButton OKButton = new JButton("Отправить");


    private JTable table;

    public KApplication() {
        super("Перечень организаций");
        Container c = getContentPane();
        ConnectionFirebird.model.setTableData(ConnectionFirebird.baza.getNomen(" Select o.code, o.firm_name, par.val from organizations o " +
                "inner join parametrs par on o.unqnumber = par.unqnumber and par.num_parametr = '2046' and par.offdate = '31.12.2999' " +
                "where o.kor_count = '62' and o.todate = '31.12.2999' and o.firm_num = '1' order by o.code "));

        table = new JTable(ConnectionFirebird.model);
        table.getColumnModel().getColumn(0).setMaxWidth(40);

        panel.add(new JTextField(27));
        panel.add(OKButton);

        c.add( new JScrollPane(table), BorderLayout.SOUTH );
        c.add(panel, BorderLayout.WEST);
        leftPanel.setBackground(new Color(0xFFFFFB));
        c.add(leftPanel, BorderLayout.EAST);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new KApplication();
    }
}
