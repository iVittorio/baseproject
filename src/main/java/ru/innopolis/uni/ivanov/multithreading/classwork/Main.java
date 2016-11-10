package ru.innopolis.uni.ivanov.multithreading.classwork;

/**
 * Created by i.viktor on 03/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Object globalLock = new Object();
        Thread timer = new Сhronometer(globalLock);
        Thread fiveSecondTimer = new SomeSecondTimer(globalLock, 5);
        Thread sevenSecondTimer = new SomeSecondTimer(globalLock, 7);
        timer.start();
        fiveSecondTimer.start();
        sevenSecondTimer.start();
    }
}
