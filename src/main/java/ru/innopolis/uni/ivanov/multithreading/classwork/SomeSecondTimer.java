package ru.innopolis.uni.ivanov.multithreading.classwork;

/**
 * Created by i.viktor on 03/11/2016.
 */
public class SomeSecondTimer extends Thread {
    private final Object lock;
    private int timer = 0;
    private final int delay;

    public int getTimer() {
        return timer;
    }

    public SomeSecondTimer(Object lock, int delay) {
        this.delay = delay;
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            while (!isInterrupted()) {
                synchronized (lock) {
                    lock.wait();
                }
                increment();
                if (getTimer() % delay == 0) {
                    System.out.println(delay + " chronometer: " + getTimer());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void increment() {
        timer++;
    }


}
