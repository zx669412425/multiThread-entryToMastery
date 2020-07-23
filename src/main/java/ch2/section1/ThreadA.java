package ch2.section1;

/**
 * @author zhangxin
 * @version 1.0
 * @date 2020/7/20 15:44
 */


public class ThreadA extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(500L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("This is Thread A");
    }
}
