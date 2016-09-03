import org.junit.Test;

/**
 * Created by XiaoNiuniu on 9/3/2016.
 */
public class LambdaTest {

    static class MyRunnable implements Runnable {

        private String message;

        public MyRunnable(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(message);
        }
    }

    @Test
    public void testLambdaInThread() {

        // A class implement Runnable
        Thread thread1 = new Thread(new MyRunnable("Thread 1 - I am a new thread"));

        // Anonymous class
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread 2 - I am a new thread");
            }
        });

        // Lambda expression
        Thread thread3 = new Thread(() -> { System.out.println("Thread 3 - I am a new thread"); });

        // Not sure how this is called
        Thread thread4 = new Thread() {
            public void run() {
                System.out.println("Thread 4 - I am a new thread");
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Main thread - done");
    }
}
