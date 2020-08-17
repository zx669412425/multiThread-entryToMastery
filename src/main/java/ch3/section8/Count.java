package ch3.section8;

public class Count {
    private byte[] lock1 = new byte[1];
    private byte[] lock2 = new byte[1];
    public int num = 0;
    public void add() {
        // 注意这个锁的对象不一样
        synchronized (lock1) {
            try {
                // 模仿用户干活
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
            // 产生死锁等待lock2对象释放锁
            synchronized (lock2) {
                num += 1;
            }
            System.out.println(Thread.currentThread().getName() + "-" + num);
        }
    }

    public void lockMethod() {
        // 注意这个锁的对象不一样
        synchronized (lock2) {
            try {
                // 模仿用户干活
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
            // 产生死锁等待lock1对象释放锁
            synchronized (lock1) {
                num += 1;
            }
            System.out.println(Thread.currentThread().getName() + "-" + num);
        }
    }
}
