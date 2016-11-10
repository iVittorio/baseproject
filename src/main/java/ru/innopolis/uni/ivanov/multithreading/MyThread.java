package ru.innopolis.uni.ivanov.multithreading;

/**
 * Created by i.viktor on 03/11/2016.
 */
public class MyThread extends Thread {
    private Box box;

    public MyThread(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            box.increment();
        }
    }
}
