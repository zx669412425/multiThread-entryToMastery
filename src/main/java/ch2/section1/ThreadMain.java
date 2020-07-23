package ch2.section1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhangxin
 * @version 1.0
 * @date 2020/7/20 15:42
 */


public class ThreadMain {
    public static void main(String[] args) {
        /*
        ThreadA threadA = new ThreadA();
        threadA.start();
        System.out.println("This is main thread");
       */

        /*
        ThreadB threadB = new ThreadB();
        new Thread(threadB).start();
        System.out.println("This is main thread");
        */

        ThreadC threadC = new ThreadC();
        FutureTask<String> futureTask = new FutureTask<String>(threadC);
        new Thread(futureTask).start();
        System.out.println("This id main Thread,begin!");
        try {
            System.out.println("Getted return result is :"+futureTask.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("This id main Thread,end!");
    }
}
