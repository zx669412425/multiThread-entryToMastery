package ch2.section1;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;

/**
 * @author zhangxin
 * @version 1.0
 * @date 2020/7/20 15:56
 */


public class ThreadC implements Callable {
    public Object call() throws Exception {
        System.out.println("ThreadC has started");
        try {
            Thread.sleep(500L);
            System.out.println("ThreadC has sleepped");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("This is thread C");
        return "thread C";
    }
}
