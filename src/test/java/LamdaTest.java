import org.junit.Test;

/**
 * Created by XiaoNiuniu on 9/3/2016.
 */
public class LamdaTest {
    @Test
    public void testLamda() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread 1 - I am a new thread");
            }
        });

        Thread thread2 = new Thread(() -> { System.out.println("Thread 2 - I am a new thread"); });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Main thread - done");
    }
}
