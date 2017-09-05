package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car {
    public int numberOfPassengers;
    public Cabriolet(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
        this.numberOfPassengers = numberOfPassengers;
    }
}
