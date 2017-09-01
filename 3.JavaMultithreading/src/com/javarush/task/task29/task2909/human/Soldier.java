package com.javarush.task.task29.task2909.human;

public class Soldier extends  Human {


    public Soldier(String name, int age) {
        this.name = name;
        this.age = age;

    }
    public Soldier(boolean isSoldier) {
        this.isSoldier = isSoldier;
        //this.id = nextId;
        nextId++;
    }

    public void live() {
        if (isSoldier)
            fight();
    }


    protected boolean isSoldier;
    String name;
    int age;

}
