package ru.innopolis.uni.ivanov.multithreading.classwork2.objectpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i.viktor on 07/11/2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ObjectPool objectPool = new ObjectPool();
        objectPool.setSize(10_000);
        objectPool.setTimeout(10_000);


        List<Thread> threadList = new ArrayList<>();
        Thread objectProducer = new ObjectProducer(objectPool);
        objectProducer.setName("Producer");
        objectProducer.start();

        for (int i = 0; i < 15; i++) {
            Thread t = new ObjectConsumer(objectPool);
            t.setName("Thread #" + i);
            threadList.add(t);
        }

        threadList.forEach(Thread::start);

    }
}
