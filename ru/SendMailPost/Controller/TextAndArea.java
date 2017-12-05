package SendMailPost.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TextAndArea extends JTextField {  //Путь к файлу
    static String paht = "C:\\pdf";
    public TextAndArea() {
    super();
    }

    public static class PathToDistributionFile extends JTextField  {
        public PathToDistributionFile (){
            super(paht); //Путь к файлу загрузки
//            addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    //JFileChooser fileChooser = new JFileChooser();
//                    //int ref = fileChooser.showDialog(null, "Открыть файл");
////                    if (ref == fileChooser.APPROVE_OPTION){
////                        File file = fileChooser.getSelectedFile();
//                        //super(String.valueOf(file.getName()) );
//                        System.out.println("sdlkfjg;ksjdf;klgj");
//                    //}
//                }
//            });

            DocumentListener doc = new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println("Insert");
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println("Update");
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("Remout");
                }
            };
            getDocument().addDocumentListener(doc);
        }
    }
}
