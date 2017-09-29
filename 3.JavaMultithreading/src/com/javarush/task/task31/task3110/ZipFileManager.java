package com.javarush.task.task31.task3110;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    private Path zipFile = null;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{
        ZipOutputStream zipFiles = new ZipOutputStream(Files.newOutputStream(zipFile));
        ZipEntry entry =  new ZipEntry(source.getFileName().toString());
        zipFiles.putNextEntry(entry);
        InputStream inputStream = Files.newInputStream(source);
        while (inputStream.available() > 0){
            zipFiles.write(inputStream.read());
        }
        inputStream.close();
        zipFiles.close();
    }

}
