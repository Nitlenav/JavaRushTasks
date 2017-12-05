package GameThread;

import java.util.ArrayDeque;
import java.util.concurrent.SynchronousQueue;

public class ThreadRead extends Thread  {
    ArrayDeque<Long> queue;
    long l = 0;

    public ThreadRead(ArrayDeque<Long> queue) {
        this.queue = queue;
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l += l;
    }

    @Override
    public void run() {
        while (queue.peek() != null) {
            setL(queue.pop());
        }
    }
}

