package GameThread;

import java.util.ArrayDeque;
import java.util.concurrent.SynchronousQueue;

public class ThreadWrite extends Thread {
    ArrayDeque<Long> queue;

    public ThreadWrite(ArrayDeque<Long> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        long min = 10;
        long max = 89;
        for (int i = 0; i < 1000; i++) {
            long num = (long) (Math.random() * max) + min;
            queue.push(num);
            System.out.println(queue.size() + " ");
        }
    }
}
