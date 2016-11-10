package ru.innopolis.uni.ivanov.multithreading;

/**
 * Created by i.viktor on 03/11/2016.
 */
public class Box {
    private int value;

    public Box(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized void increment(){
        value++;
    }
}
