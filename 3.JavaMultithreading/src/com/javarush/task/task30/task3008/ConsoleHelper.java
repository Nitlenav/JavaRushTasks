package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader bufferedReader;

    public static void writeMessage(String message){
        System.out.println(message);

    }

    public String readString(){
        String s;
        while (true){
            try {
                s = new BufferedReader(new InputStreamReader(System.in)).readLine();
                break;
            }
            catch (IOException e){
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return s;
    }

    public int readInt(){
        int i;
        while (true){
            try {
                i = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return i;
    }
}
