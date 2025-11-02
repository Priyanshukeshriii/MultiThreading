package sequential;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final  Lock lock = new ReentrantLock(true);
    void outerMethod(){
        lock.lock();
        try {
            System.out.println("Outer Method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }

    void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner Method");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        reentrantLockExample.outerMethod();
    }

}
