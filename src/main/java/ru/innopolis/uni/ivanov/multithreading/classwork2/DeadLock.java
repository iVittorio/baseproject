package ru.innopolis.uni.ivanov.multithreading.classwork2;

/**
 * Created by i.viktor on 07/11/2016.
 */
public class DeadLock {
    public volatile static Object lock1 = new Object();
    public volatile static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread someObj1 = new SomeObj(lock1, lock2);
        Thread someObj2 = new SomeObj(lock2, lock1);

        someObj1.start();
        someObj2.start();
    }

}
