package ru.SendFileForEmail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragExample extends JFrame {

    final private JPanel panel;
    final private JPanel panel2;

    public DragExample() {
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        panel = new JPanel();
        panel2 = new JPanel();
        panel.setOpaque(true);
        panel2.setOpaque(true);
        panel.setBackground(Color.BLUE);
        panel2.setBackground(Color.CYAN);

        MoveListener ml = new MoveListener();
        panel.addMouseListener(ml);
        panel2.addMouseListener(ml);
        panel.addMouseMotionListener(ml);
        panel2.addMouseMotionListener(ml);

        panel.setSize(new Dimension(100, 100));
        panel2.setSize(new Dimension(100, 100));
        panel.setLocation(200, 100);
        panel2.setLocation( 100, 100);

        this.add(panel);
        this.add(panel2);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DragExample();
    }

    class MoveListener extends MouseAdapter {

        private Point old;


        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            old = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            //old.setLocation(e.getX(), e.getY());
            panel.setLocation(panel.getX() + e.getX()- (int)old.getX() , panel.getY());
            panel2.setLocation(panel2.getX() + e.getX() - (int)old.getX(), panel2.getY());
            //panel.setLocation(panel.getX() + e.getX()- (int)old.getX() , panel.getY() + e.getY() - (int)old.getY());
            //panel2.setLocation(panel2.getX() + e.getX() - (int)old.getX(), panel2.getY() + e.getY() - (int)old.getY());
            //old = e.getPoint();
        }
    }
}