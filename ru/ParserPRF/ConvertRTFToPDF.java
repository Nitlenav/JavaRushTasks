package ParserPRF;

import com.lowagie.text.Document;
import com.lowagie.text.rtf.field.RtfPageNumber;
import com.lowagie.text.rtf.parser.RtfParser;

import java.io.*;

public class ConvertRTFToPDF {


    public static void main(String[] args) throws FileNotFoundException {

        String inputFile = "E:\\voip.rtf";
        String outputFile = "E:\\voip.pdf";
        InputStream in = new FileInputStream(new File(inputFile));
        OutputStream out = new FileOutputStream(new File(outputFile));

        RtfPageNumber number = new RtfPageNumber();
        Document doc = new Document();
        RtfParser parser = new RtfParser(doc);
    }
}
