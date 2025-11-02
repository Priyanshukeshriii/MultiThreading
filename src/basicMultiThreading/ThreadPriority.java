package basicMultiThreading;

public class ThreadPriority {
    public static  void main(String[] args) {
        System.out.println( Thread.currentThread().getName()+" :"+Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getName()+" Hello from main");
//
//        hence shown that priority dose not guarantee the order of execution


//        for this task the order of execution was main -> t2 -> t1;
//        Thread t1 = new Thread(() ->{
//            System.out.println("hello from t1");
//        });
//
//        Thread t2 = new Thread(() ->{
//            System.out.println("hello from t2");
//        });

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 100; i++) {

            System.out.println("hello from t1 : "+i);
            }
        });

        Thread t2 = new Thread(() ->{
            for (int i = 0 ; i < 100 ;i++){

            System.out.println("hello from t2 : "+i);
            }
        });


        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        //start the low priority first
        t2.start();
        t1.start();

        //start the high priority first
//        t1.start();
//        t2.start();
    }
}
