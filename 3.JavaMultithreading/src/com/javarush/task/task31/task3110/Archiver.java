package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите полный путь архива.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        while (path.length() <= 0){
            path = reader.readLine();
        }
        ZipFileManager zipMan = new ZipFileManager(Paths.get(path));
        System.out.println("Ведите путь к файлу, который будем архивировать.");
        BufferedReader readerZipPath = new BufferedReader(new InputStreamReader(System.in));
        String zipPath = readerZipPath.readLine();
        while (zipPath.length() <= 0){
            zipPath = readerZipPath.readLine();
        }
        zipMan.createZip(Paths.get(zipPath));

    }
}
