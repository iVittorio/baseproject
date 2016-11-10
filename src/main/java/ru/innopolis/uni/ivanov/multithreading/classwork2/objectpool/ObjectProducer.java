package ru.innopolis.uni.ivanov.multithreading.classwork2.objectpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i.viktor on 07/11/2016.
 */
public class ObjectProducer extends Thread {
    private final ObjectPool objectPool;
    private List<Object> objectsList = new ArrayList<>();

    public ObjectProducer(ObjectPool objectPool) {
        this.objectPool = objectPool;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " START!");

        for (int i = 0; i < 10_000; i++) {
            Object object = null;
            try {
                object = objectPool.getObject();
            } catch (PoolException e) {
                e.printStackTrace();
            }
            objectsList.add(object);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        objectsList.forEach(objectPool::returnObject);

        System.out.println(Thread.currentThread().getName() + " FINISH!");

    }
}
