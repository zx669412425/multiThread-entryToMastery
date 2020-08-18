package ch3.section4;

/**
 * wait方法为什么要在同步块中使用
 */x
public class Main {
    static Main a = new Main();
    public static void main(String[] args) {

        System.out.println("======");
        //f1();
        f2();
        System.out.println("-----");
    }
    static void f1(){
        try{
            synchronized (a){
                a.wait(10000);
                System.out.println("111111");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    static void f2(){
        try{
            a.wait(10000);
            System.out.println("111111");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
