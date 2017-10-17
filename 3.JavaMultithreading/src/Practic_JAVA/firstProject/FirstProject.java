package Practic_JAVA.firstProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class FirstProject {
    private int count = 0;
    private final int number = new Random().nextInt(1000);
    private int num = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void numKa() throws IOException {
        while (true){
            num = Integer.parseInt(reader.readLine());
            if (num > number){
                ConsolWrite.writeMessage("Введённое число больше ЗАГАДАНОГО.");
                count++;
            }else if (num < number){
                ConsolWrite.writeMessage("Введённое число меньше ЗАГАДАНОГО.");
                count++;
            }else if (num == number){
                ConsolWrite.writeMessage("Ты угадал ЗАГАДАНОЕ число с " + count +  " попытки.");
                break;
            }
        }
    }




}
