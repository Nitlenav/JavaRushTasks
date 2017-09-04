package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    String name;
    int age;
    private List<Student> students = new ArrayList<Student>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade( double averageGrade ) {
        Student student = null;
        for (Student stud : students){
            if (stud.getAverageGrade() == averageGrade){
                student = stud;
                break;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student = null;
        double maxAverage = 0.0;
        for (Student stud: students){
            if (stud.getAverageGrade() > maxAverage){
                maxAverage = stud.getAverageGrade();
                student = stud;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = null;
        double minAvetage = Double.MAX_VALUE;
        for (Student stud : students){
            if (stud.getAverageGrade() < minAvetage){
                minAvetage = stud.getAverageGrade();
                student = stud;
            }
        }
        return student;
    }

    public void expel(Student student){
        students.remove(student);
    }
}