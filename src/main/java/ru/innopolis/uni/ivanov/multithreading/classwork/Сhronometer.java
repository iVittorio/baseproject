package ru.innopolis.uni.ivanov.multithreading.classwork;

/**
 * Created by i.viktor on 03/11/2016.
 */
public class Сhronometer extends Thread {
    private int seconds = 0;
    private final Object lock;

    public Сhronometer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                notifier();
                System.out.println("Сhronometer: " + getSeconds());
                Thread.sleep(1000);
                increment();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void notifier() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    private void increment() {
        seconds++;
    }

    public int getSeconds() {
        return seconds;
    }


}
