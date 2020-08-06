package ch2.section8;

public class ThreadB implements Runnable{
    @Override
    public void run() {
        System.out.println("thread is running");
        int number0 = Integer.parseInt("TTT");
    }
}
