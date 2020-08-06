package ch2.section8;

/**
 * @author Administrator
 */
public class ThreadMain {
    public static void main(String[] args) {
        ThreadB task = new ThreadB();
        Thread thread = new Thread(task);
        //thread.setUncaughtExceptionHandler(new ExceptionHandlerThreadB());
        thread.start();
        System.out.println("wait for thread");
        System.out.println("wait for thread====");
    }
}
