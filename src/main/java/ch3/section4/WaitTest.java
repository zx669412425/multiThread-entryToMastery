package ch3.section4;

import java.util.stream.Stream;

/**
 * wait() 会释放CPU资源，同时释放锁
 * 在某一线程执行wait()方法后，其他线程可获得锁资源
 */
public class WaitTest {
    public static final Object lock = new Object();
    public static void main(String[] args) {
        Stream.of("thread1","thread2").forEach(n -> new Thread(n){
            @Override
            public void run() {
                test();
            }
        }.start());
    }
    public static void test(){
        synchronized (lock){
            try{
                System.out.println(Thread.currentThread().getName()+" is running");
                lock.wait(10000L);
                System.out.println(Thread.currentThread().getName()+" wait over");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
