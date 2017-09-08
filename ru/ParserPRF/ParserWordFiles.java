package ru.ParserPRF;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;

/**
 * Created by lav on 30.05.2017.
 */
public class ParserWordFiles {
    public static void main (String args []) throws IOException {
        //String fileInDocx = "E:\\voip.docx";
        //String fileInRtf = "E:\\voip.rtf";
        String fileInDoc = "E:\\voip.doc";
        String fileOut = "E:\\voip2.doc";
        InputStream inDoc = new FileInputStream(fileInDoc);
        FileOutputStream out = new FileOutputStream(new File(fileOut));

        WordExtractor extractor;
        HWPFDocument documentextract = null;
        try {
            documentextract = new HWPFDocument(inDoc);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        extractor = new WordExtractor(documentextract);
        String[] paragraphs = extractor.getParagraphText();
        int pageCount = 0;
        int countParagraf = 0;
        for (String par :paragraphs) {
            ++countParagraf;
            if (par.indexOf("\f") >= 0) {
                ++pageCount;
                System.out.println(countParagraf);
            }
        }
        Range range = new Range(0, 70, documentextract);
        documentextract.write(out);


        //documentextract.
//
//        XWPFDocument document = new XWPFDocument();
//        XWPFParagraph paragraph = document.createParagraph();
//        paragraph.createRun();
//        XWPFRun run = paragraph.createRun();
//        document.write(out);
//        document.close();
//        XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
//        System.out.println(wordExtractor.getText());


        //in.close();
        inDoc.close();
        out.close();
        System.out.println(pageCount + " " + countParagraf +" " + paragraphs.length);

    }
}

