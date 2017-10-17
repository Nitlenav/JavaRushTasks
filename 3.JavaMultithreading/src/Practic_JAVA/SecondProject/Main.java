package Practic_JAVA.SecondProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static Student student = new Student();
    private static String studentName = "";

    public static void main(String[] args) throws IOException {
        student.addStudent("Вася", new LessonsValue(Lessons.Биология, "норм"));
        student.addStudent("Вася", new LessonsValue(Lessons.География, "пойдёт"));
        student.addStudent("Вася", new LessonsValue(Lessons.Математика, "как то"));
        student.addStudent("Вася", new LessonsValue(Lessons.Химия, "отл"));
        student.addStudent("Вася", new LessonsValue(Lessons.Физика, "отл"));
        student.addStudent("Коля", new LessonsValue(Lessons.Биология, "норм"));
        student.addStudent("Коля", new LessonsValue(Lessons.География, "пойдёт"));
        student.addStudent("Саша", new LessonsValue(Lessons.Математика, "как то"));
        student.addStudent("Саша", new LessonsValue(Lessons.Химия, "отл"));
        student.addStudent("Саша", new LessonsValue(Lessons.Физика, "отл"));
        View.info();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            switch (reader.readLine()) {
                case "1":
                    student.addStudent(reader.readLine(), new LessonsValue(null, null));
                    ConsolWrite.writeMessage("Студент успешно добавлен");
                    break;
                case "2":
                    student.allStudents();
                    System.out.println();
                    View.info();
                    break;
                case "3":
                    ConsolWrite.writeMessage("Введите через пробел ФИО студента, номер предмета и оценку");
                    for (Lessons val : Lessons.values()) {
                        ConsolWrite.writeMessage(val.ordinal() + " - " + val.toString());
                    }
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    String stringVal[] = reader.readLine().split(" ");
                    studentName = stringVal[0];
                    if (stringVal.length < 3) {
                        ConsolWrite.writeMessage("мало аргументов");
                        View.info();
                        break;
                    }
                    try {
                        int numLessons = Integer.parseInt(stringVal[stringVal.length - 2]);
                        for (Lessons val : Lessons.values()) {
                            if (val.ordinal() == numLessons) {
                                student.addStudent(studentName, new LessonsValue(val, stringVal[stringVal.length - 1]));
                                ConsolWrite.writeMessage("Студент успешно добавлен");
                                ConsolWrite.writeMessage("");
                                View.info();
                                break;
                            }
                        }
                    } catch (Exception e) {
                        ConsolWrite.writeMessage("Не корректно введена строка");
                        View.info();
                        break;
                    }
                    break;
                case "4":
                    BufferedReader readerNameStudens = new BufferedReader(new InputStreamReader(System.in));
                    student.infoStudent(readerNameStudens.readLine());
                    ConsolWrite.writeMessageLine("");
                    View.info();
                    break;
                case "5":
                    student.allStudentTekeSession();
                    break;
                case "6":
                    return;
                default:
                    ConsolWrite.writeMessage("Нет такого числа");
                    View.info();
                    break;
            }
        }
    }
}
