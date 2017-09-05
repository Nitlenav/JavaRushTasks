package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car {
    private final int MAX_CABRIOLET_SPEED = 90;
    private int numberOfPassengers;

    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
