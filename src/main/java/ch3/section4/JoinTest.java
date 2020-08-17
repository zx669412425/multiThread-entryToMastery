package ch3.section4;

/**
 * join的意思是使得放弃当前线程的执行，并返回对应的线程。
 * 程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
 * 所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
 * t2、t3类似
 */
public class JoinTest {
    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("thread1");
        ThreadTest t2 = new ThreadTest("thread2");
        ThreadTest t3 = new ThreadTest("thread3");

        t1.start();
        System.out.println("main thread");

        try{
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t2.start();
        System.out.println("main thread");

        try{
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t3.start();
        System.out.println("main thread");

        try{
            t3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
class ThreadTest extends Thread{
    public ThreadTest(String thread1) {
        super(thread1);
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"   "+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
