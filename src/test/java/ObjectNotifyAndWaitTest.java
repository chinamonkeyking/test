/**
 * Created by XiaoNiuniu on 5/8/2016.
 */
public class ObjectNotifyAndWaitTest {

    public Object obj = new Object();

    public static void main(String args[]) {
        ObjectNotifyAndWaitTest objectNotifyAndWaitTest = new ObjectNotifyAndWaitTest();
        System.out.println("before wait");
        synchronized (objectNotifyAndWaitTest) {
            try {
                objectNotifyAndWaitTest.notify();
                objectNotifyAndWaitTest.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("after wait");
    }
}
