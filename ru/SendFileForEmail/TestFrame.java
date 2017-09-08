package ru.SendFileForEmail;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TestFrame {

    public static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

//        JPanel northPanel = new JPanel();
//        Border northBorder = BorderFactory.createTitledBorder("NORTH panel");
//        northPanel.setBorder(northBorder);
//
//        northPanel.add(createEmptyLabel());
//
//        mainPanel.add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        Border southBorder = BorderFactory.createTitledBorder("SOUTH panel");
        southPanel.setBorder(southBorder);

        southPanel.add(createEmptyLabel());

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        JPanel westPanel = new JPanel();
        Border westBorder = BorderFactory.createTitledBorder("WEST panel");
        westPanel.setBorder(westBorder);

        westPanel.add(createEmptyLabel());

        mainPanel.add(westPanel, BorderLayout.WEST);

        JPanel eastPanel = new JPanel();
        Border eastBorder = BorderFactory.createTitledBorder("EAST panel");
        eastPanel.setBorder(eastBorder);

        eastPanel.add(createEmptyLabel());

        mainPanel.add(eastPanel, BorderLayout.EAST);

        JPanel centerPanel = new JPanel();
        Border centerBorder = BorderFactory.createTitledBorder("CENTER panel");
        centerPanel.setBorder(centerBorder);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        frame.getContentPane().add(mainPanel);

        frame.setPreferredSize(new Dimension(550, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static JLabel createEmptyLabel() {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(100, 30));
        return label;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //JFrame.setDefaultLookAndFeelDecorated(false);
                createGUI();
            }
        });
    }
}
