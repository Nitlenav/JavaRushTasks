package com.javarush.task.task29.task2909.human;

public class UniversityPerson extends Human {

    private University university;


    public UniversityPerson(String name, int age, University university) {
        super(name, age);
        this.university = university;
    }


    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public UniversityPerson(boolean isSoldier) {
        super(isSoldier);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

}
