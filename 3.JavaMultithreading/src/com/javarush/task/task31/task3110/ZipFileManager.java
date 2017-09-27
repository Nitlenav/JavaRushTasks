package com.javarush.task.task31.task3110;

import java.nio.file.Path;

public class ZipFileManager {

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{}

    private Path zipFile = null;
}
