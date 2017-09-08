package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    private ConcurrentHashMap map;

    @Override
    public void run() {

    }
}
