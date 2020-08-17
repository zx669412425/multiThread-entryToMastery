package ch3.section11;

import java.util.concurrent.locks.ReentrantLock;

/*
 class Singleton {
 private static Singleton instance;
 private static ReentrantLock lock = new ReentrantLock();

 private Singleton() {
 }

 public static Singleton getInstance() {
 if (instance == null) {
 lock.lock();
 if (instance == null) {
 instance = new Singleton();
 }
 lock.unlock();
 }
 return instance;
 }
 }
 */

/**
 *
 */
class Singleton {
    private static Singleton instance;
    private static ReentrantLock lock = new ReentrantLock();

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            lock.lock();try {
                if (instance == null) {
                    instance = new Singleton();
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }
}
