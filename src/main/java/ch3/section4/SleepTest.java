package ch3.section4;

import java.util.stream.Stream;

/**
 *sleep()方法不会释放锁，会释放CPU资源
 * 某一个线程获得CPU资源后，会执行，在休眠后再次执行,其他线程无法获得锁
 */
public class SleepTest {
    public final static Object lock = new Object();
    public static void main(String[] args) {
        Stream.of("thread1","thread2").forEach(n -> new Thread(n){
            @Override
            public void run(){
                test();
            }
        }.start());
    }
    public static void test(){
        synchronized (lock){
            try{
                System.out.println(Thread.currentThread().getName()+" is running");
                Thread.sleep(10000L);
                System.out.println(Thread.currentThread().getName()+" sleep over");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
