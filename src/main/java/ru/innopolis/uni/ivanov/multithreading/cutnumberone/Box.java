package ru.innopolis.uni.ivanov.multithreading.cutnumberone;

import java.util.Map;

/**
 * Created by i.viktor on 08/11/2016.
 */
public class Box {
    private volatile Map<Integer, Integer> sharedMap;
    private volatile int seconds;
    private volatile boolean isFinish;

    public Box(Map<Integer, Integer> sharedMap, boolean isFinish, int seconds) {
        this.isFinish = isFinish;
        this.seconds = seconds;
        this.sharedMap = sharedMap;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public int getSeconds() {
        return seconds;
    }

    public Map<Integer, Integer> getSharedMap() {
        return sharedMap;
    }

    public void incrementSecond() {
        seconds++;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }
}
