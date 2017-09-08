package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    private BlockingQueue queue = null;

    @Override
    public void run() {
        while (queue.size()> 0) try {
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
