package SendMailPost.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFileInPath { //Поиск пути к файлу и возврат списка из найденых путей.
    private String path;
    private String buhCode;
    private ArrayList<String> pathFiles;
    //private File fileIn = new File(this.path);
    private File fileIn = new File("C:\\pdf");

//    public void setPath(String path) {
//        this.path = path;
//    }
//
//    public void setBuhCode(String buhCode) {
//        this.buhCode = buhCode;
//    }

    public FindFileInPath(String buhCode, String path) {
        this.buhCode = buhCode;
        this.path = path;
    }

    public ArrayList<String> getPathFile (){
        pathFiles = new ArrayList<String>();
        File[] paht = fileIn.listFiles();
        for (File s : paht){
            if (s.getName().matches("\\d+_\\d+_" + this.buhCode + "_\\d+_\\w+.pdf")){
                pathFiles.add(s.getAbsolutePath().toString());
            }
        }
        return pathFiles;
    }

}
