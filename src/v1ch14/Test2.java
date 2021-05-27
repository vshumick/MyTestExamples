package v1ch14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.MAX_PRIORITY;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ////////////////////////////////////////////

        System.out.println(Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        //myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        //thread2.start();

       /* new MyThread().start();

        MyRunnable myRunnable2 = new MyRunnable();
        new Thread(myRunnable2).start();*/

        ExecutorService exec = Executors.newCachedThreadPool();
        MyThread myThread3 = new MyThread();
        MyRunnable myRunnable4 = new MyRunnable();
        exec.execute(myThread);
        exec.execute(thread2);
        exec.execute(myThread3);
        exec.execute(myRunnable4);

        exec.shutdown();

        /*myThread.join();
        thread2.join();
        myThread3.join();*/

        exec.awaitTermination(60, TimeUnit.MINUTES);

        ////////////////////////////////////////////
        long timeEnd = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (timeEnd - timeStart));

    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread:" + Thread.currentThread().getName());
        for (int i=0; i<10; i++){
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable:" + Thread.currentThread().getName());
        for (int i=0; i<10; i++){
            System.out.println(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

