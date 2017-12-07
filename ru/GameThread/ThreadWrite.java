package GameThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

public class ThreadWrite extends Thread {
    private BlockingQueue<Long> queue;
    private Lock lock;
    long min = 10;
    long max = 89;

    public ThreadWrite(BlockingQueue<Long> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        for (int i = 0; i < 1000; i++) {
            long num = (long) (Math.random() * max) + min;
            try {
                queue.put(num);
                //System.out.println(queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
                lock.unlock();
            }
        }
        lock.unlock();
    }
}
