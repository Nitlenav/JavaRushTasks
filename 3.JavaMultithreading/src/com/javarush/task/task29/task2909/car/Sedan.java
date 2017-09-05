package com.javarush.task.task29.task2909.car;

public class Sedan extends Car {

    public int numberOfPassengers;
    public Sedan(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
        this.numberOfPassengers = numberOfPassengers;
    }
}
