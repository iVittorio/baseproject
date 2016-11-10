package ru.innopolis.uni.ivanov.multithreading.submultithread;

/**
 * Created by i.viktor on 03/11/2016.
 */
public class MyThread extends Thread {

    private Object monitor;

    public MyThread(Object monitor) {
        this.monitor = monitor;
    }


    @Override
    public void run() {
        System.out.println("Thread runned!");
        synchronized (monitor) {
            try {
                while (Main.predicate) {
                    monitor.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("This is the catch block!");
            }
            System.out.println("Thread execution!");
        }
    }
}
