package sequential;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterfaceDemo {
    public static void main(String[] args) {
        BankAccountUsingLock sib = new BankAccountUsingLock();
        Runnable w1  = new Runnable() {
            @Override
            public void run() {
                sib.withdraw(20);
            }
        };
        Thread t1 = new Thread(w1,"First Withdrawal");
        Thread t2 = new Thread(w1,"Second Withdrawal");
        t1.start();
        t2.start();

    }
}

class BankAccountUsingLock {

    private  final Lock  lock = new ReentrantLock();

    private int balance = 10;

    void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() +" trying to withdraw "+ amount);

        try {
            if(lock.tryLock(1000 , TimeUnit.MILLISECONDS) ){
                try{
                    if(balance > amount){
                        System.out.println(Thread.currentThread().getName() + " is withdrawing");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " withdrawal completed . Remaining balance :"+ balance);
                    }
                    else{
                        System.out.println("SORRY YOU HAVE INSUFFICIENT BALANCE");
                    }
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally {
                    lock.unlock();
                }
            }else {
                System.out.println("The server is busy!! Try again later.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}