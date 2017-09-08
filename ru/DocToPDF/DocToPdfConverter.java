//package ru.DocToPDF;
//
//import com.lowagie.text.Document;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.PdfWriter;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.extractor.WordExtractor;
//import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//
//public class DocToPdfConverter{
//
//    public static void main(String[] args) {
//
//        String k=null;
//        OutputStream fileForPdf =null;
//        try {
//
//            String fileName="E:\\voip.doc";
//            //Below Code is for .doc file
//            if(fileName.endsWith(".doc"))
//            {
//                HWPFDocument doc = new HWPFDocument(new FileInputStream(
//                        fileName));
//                WordExtractor we=new WordExtractor(doc);
//                k = we.getText();
//
//                fileForPdf = new FileOutputStream(new File("E:\\voip.pdf"));
//                we.close();
//            }
//
//            //Below Code for
//
//            else if(fileName.endsWith(".docx"))
//            {
//                XWPFDocument docx = new XWPFDocument(new FileInputStream(
//                        fileName));
//                // using XWPFWordExtractor Class
//                XWPFWordExtractor we = new XWPFWordExtractor(docx);
//                k = we.getText();
//
//                fileForPdf = new FileOutputStream(new File(
//                        "/document/DocxToPdf.pdf"));
//                we.close();
//            }
//
//
//
//            Document document = new Document();
//            PdfWriter.getInstance(document, fileForPdf);
//
//            document.open();
//
//            document.add(new Paragraph(k));
//
//            document.close();
//            fileForPdf.close();
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}