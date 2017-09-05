package com.javarush.task.task29.task2909.car;

public class Truck extends Car {
    public int numberOfPassengers;
    public Truck(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
        this.numberOfPassengers = numberOfPassengers;
    }

}
