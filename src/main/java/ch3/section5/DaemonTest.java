package ch3.section5;

/**
 * 守护线程在前台线程执行完后会退出
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread tA = new ThreadA();
        Thread tB = new ThreadB();
        tB.setDaemon(true);

        tA.start();
        tB.start();

        Thread mainThread = Thread.currentThread();
        System.out.println("线程A是不是守护线程"+tA.isDaemon());
        System.out.println("线程B是不是守护线程"+tB.isDaemon());
        System.out.println("main线程是不是守护线程"+mainThread.isDaemon());
    }
}
class ThreadA extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("threadA ==== " + i + "===============");
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 0 ;i<9999999;i++){
            System.out.println("threadB " + i);
        }
        try{
            Thread.sleep(100000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
