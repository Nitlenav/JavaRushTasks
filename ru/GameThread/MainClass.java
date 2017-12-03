package GameThread;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.concurrent.SynchronousQueue;

public class MainClass {
    static volatile ArrayDeque<Long> queue = new ArrayDeque<Long>();
    public static void main(String[] args) throws InterruptedException {

        ThreadWrite write = new ThreadWrite(queue);
        Thread threadWrite = new Thread(write);

        ThreadRead read_1 = new ThreadRead(queue);
        Thread thread_1 = new Thread(read_1);

        ThreadRead read_2 = new ThreadRead(queue);
        Thread thread_2 = new Thread(read_2);

        ThreadRead read_3 = new ThreadRead(queue);
        Thread thread_3 = new Thread(read_3);

        write.run();
        //Thread.sleep(100);
        thread_1.start();
        //Thread.sleep(100);
        thread_2.start();
        //Thread.sleep(100);
        thread_3.start();
        System.out.println(read_1.getL());
        System.out.println(read_2.getL());
        System.out.println(read_3.getL());
        //write.writeQueue();
    }
}
