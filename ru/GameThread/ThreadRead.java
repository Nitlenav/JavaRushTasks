package GameThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class ThreadRead extends Thread {
    private BlockingQueue<Long> queue;
    private Lock lock;
    private long l = 0;

    public ThreadRead(BlockingQueue<Long> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l += l;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " - " + queue.size());
//        synchronized (queue) {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                long num;
                while ((num = queue.take()) != 0) {
                    setL(num);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

