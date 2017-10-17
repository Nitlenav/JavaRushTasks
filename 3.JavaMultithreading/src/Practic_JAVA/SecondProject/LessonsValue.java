package Practic_JAVA.SecondProject;

import java.util.HashMap;
import java.util.Map;

public class LessonsValue {
    private Lessons lessons;
    private String values;
    private  Map<Lessons, String> mapLessons = new HashMap<>();

    public Lessons getLessons() {
        return lessons;
    }

    public String getValues() {
        return values;
    }

    public void putMapLessons(Lessons lessons, String values) {
        mapLessons.put(lessons, values);
    }

    public Map<Lessons, String> getMapLessons() {
        return mapLessons;
    }

    public LessonsValue(Lessons lessons, String values) {
        this.lessons = lessons;
        this.values = values;
    }
}
