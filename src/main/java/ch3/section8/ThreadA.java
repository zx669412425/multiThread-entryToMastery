package ch3.section8;

public class ThreadA extends Thread {
    private Count count;
    public ThreadA(Count count) {
        this.count=count;
    }
    public void run() {
        count.add();
    }
}
