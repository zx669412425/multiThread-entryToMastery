package ch3.section8;

public class ThreadB extends Thread {
    private Count count;
    public ThreadB(Count count) {
        this.count=count;
    }
    public void run() {
        count.lockMethod();
    }
}
