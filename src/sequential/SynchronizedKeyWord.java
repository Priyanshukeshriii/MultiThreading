package sequential;

public class SynchronizedKeyWord {
    static int counter =0;

    public static void main(String[] args) {
        Thread one  = new Thread(() -> {
            for (int i = 0 ; i< 10000 ; i++){
                increment();
            }
        });
        Thread two  = new Thread(() -> {
            for (int i = 0 ; i< 10000 ; i++){
                increment();
            }
        });
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);

    }
        private synchronized static void increment(){
            counter++;
        }
}
