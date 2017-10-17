package Practic_JAVA.SecondProject;


import java.util.HashMap;
import java.util.Map;

public class Student {
    private  Map<String, LessonsValue> listLessons = new HashMap<String, LessonsValue>();
    private String nameStudent;
    private LessonsValue lessonsValue;

    public Map<String, LessonsValue> getListLessons() {
        return listLessons;
    }

    public void setLessonsValue(LessonsValue lessonsValue) {
        this.lessonsValue = lessonsValue;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public void addStudent(String nameStudent, LessonsValue lessons) {
        if (listLessons.containsKey(nameStudent)) {
            LessonsValue les = listLessons.get(nameStudent);
            les.putMapLessons(lessons.getLessons(), lessons.getValues());
        } else {
            listLessons.put(nameStudent, lessons);
        }
    }

    public void allStudents() {
        for (Map.Entry<String, LessonsValue> entry : listLessons.entrySet()) {
            ConsolWrite.writeMessageLine(entry.getKey()+ " ");
        }
    }

    public void infoStudents() {
        for (Map.Entry<String, LessonsValue> entry : listLessons.entrySet()) {
            ConsolWrite.writeMessage("Студент: " + entry.getKey() + " сдал предмет");
            for (Map.Entry<Lessons, String> mapEntry : entry.getValue().getMapLessons().entrySet()) {
                ConsolWrite.writeMessage("Предмет - " + mapEntry.getKey() + " оценка - " + mapEntry.getValue());
            }
        }
    }

    public void infoStudent(String nameStudent) {
        if (listLessons.containsKey(nameStudent)) {
            LessonsValue lessonsValue = listLessons.get(nameStudent);
            Map<Lessons, String> lessonsMap = lessonsValue.getMapLessons();
            ConsolWrite.writeMessageLine("Студент " + nameStudent + " сдал предмет ");
            for (Map.Entry<Lessons, String> entry : lessonsMap.entrySet()) {
                ConsolWrite.writeMessageLine("Предмет - " + entry.getKey() + " оценка - " + entry.getValue());
            }
        }else ConsolWrite.writeMessageLine("Студента с таким именем нет в скиске или студент низдал ниобного предмета");
    }

    public void oneStudent(String nameStudent) {
        for (Map.Entry<String, LessonsValue> entry : listLessons.entrySet()) {
            if (entry.getKey() == nameStudent) {
                ConsolWrite.writeMessage("Студент: " + entry.getKey() + "сдал предмет");
                for (Map.Entry<Lessons, String> mapEntry : entry.getValue().getMapLessons().entrySet()) {
                    ConsolWrite.writeMessage("Предмет - " + mapEntry.getKey() + " оценка - " + mapEntry.getValue());
                }
            }
        }
    }

    public void allStudentTekeSession() {
        for (Map.Entry<String, LessonsValue> entry : listLessons.entrySet()) {
            if ( entry.getValue() == null) continue;
            if (entry.getValue().getMapLessons().size() > 3) {
                ConsolWrite.writeMessage("Студент: " + entry.getKey() + " допущен к сессии");
            }
        }
    }
}
