package basicMultiThreading;

public class DemonThread {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new DemonHelper());
        Thread thread2 = new Thread(new UserThread());
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
    }


}
class  DemonHelper implements Runnable{

    @Override
    public void run() {
        int count = 0 ;
        while (count < 100){
            count++;
            System.out.println("From demon thread :"+count );
            try {
                Thread.sleep(1000); //sleep is the static method
            } catch (InterruptedException e) {
                e.getMessage();
            }

        }
    }

}

class UserThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.getMessage();
            e.printStackTrace();
        }
        System.out.println("end of execution of user thread");

    }
}
