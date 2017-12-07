package GameThread;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    static volatile BlockingQueue<Long> queue = new ArrayBlockingQueue<Long>(1000, true);
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

        ThreadWrite write = new ThreadWrite(queue, lock);
        //Thread threadWrite = new Thread(write);

        ThreadRead read_1 = new ThreadRead(queue, lock);
        //Thread thread_1 = new Thread(read_1);

        ThreadRead read_2 = new ThreadRead(queue, lock);
        //Thread thread_2 = new Thread(read_2);

        ThreadRead read_3 = new ThreadRead(queue, lock);
        //Thread thread_3 = new Thread(read_3);

        write.start();

        read_1.start();
        read_2.start();
        read_3.start();

        System.out.println(read_1.getName() + " " + read_1.getL());
        System.out.println(read_2.getName() + " " + read_2.getL());
        System.out.println(read_3.getName() + " " + read_3.getL());
        //write.writeQueue();
    }
}
