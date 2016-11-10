package ru.innopolis.uni.ivanov.multithreading.cutnumberone;

import java.util.Map;

/**
 * Created by i.viktor on 08/11/2016.
 * 
 */
public class ThreadGenerator extends Thread {
    private final Box box;

    public ThreadGenerator(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (!isInterrupted() && !box.isFinish()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (box.getSharedMap()) {
                addToMapPerSecond(box.getSharedMap(), randomValueGenerator());
                box.incrementSecond();
                box.getSharedMap().notify();
            }
        }
    }

    public void addToMapPerSecond(Map<Integer, Integer> map, int num) {
        if (map.containsKey(num)) map.put(num, map.get(num) + 1);
        else map.put(num, 1);
    }

    public int randomValueGenerator() {
        return (int) (Math.random() * 100);
    }
}
