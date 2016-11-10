package ru.innopolis.uni.ivanov.multithreading.submultithread;

/**
 * Created by i.viktor on 03/11/2016.
 */
public class Main {
    static boolean predicate = true;
    public static void main(String[] args) {

        Object globalMonitor = new Object();
        Thread thread = new MyThread(globalMonitor);
        thread.start();

        calculate();


        synchronized (globalMonitor) {
            predicate = false;
            globalMonitor.notify();
        }

    }

    private static void calculate() {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Calculate method is over");

    }
}
