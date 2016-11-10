package ru.innopolis.uni.ivanov.multithreading.classwork2;

/**
 * Created by i.viktor on 07/11/2016.
 */
public class SomeObj extends Thread {
    public SomeObj(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    private final Object lock1, lock2;

    @Override
    public void run() {
        try {
            doSome();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doSome() throws InterruptedException {
        synchronized (lock1){
            System.out.println("Первый лок");
            Thread.sleep(1000);
            synchronized (lock2){
                System.out.println("Второй лок");
            }
        }
    }
}
