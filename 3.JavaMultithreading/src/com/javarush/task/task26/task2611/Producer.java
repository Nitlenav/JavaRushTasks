package com.javarush.task.task26.task2611;

import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    private ConcurrentHashMap <String, String> map = new ConcurrentHashMap<String, String>();

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            int i = 1;
            map.put(String.valueOf(i), "Some text for " + i++);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}
