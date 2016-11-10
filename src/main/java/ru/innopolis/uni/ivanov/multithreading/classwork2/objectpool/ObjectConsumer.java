package ru.innopolis.uni.ivanov.multithreading.classwork2.objectpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i.viktor on 07/11/2016.
 */
public class ObjectConsumer extends Thread {
    private final ObjectPool objectPool;
    private List<Object> objectsList = new ArrayList<>();

    public ObjectConsumer(ObjectPool objectPool) {
        this.objectPool = objectPool;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " START!");

        for (int i = 0; i < 1_000; i++) {
            try {
                objectsList.add(objectPool.getObject());
            } catch (PoolException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        objectsList.forEach(objectPool::returnObject);

        System.out.println(Thread.currentThread().getName() + " FINISH!");
    }
}
