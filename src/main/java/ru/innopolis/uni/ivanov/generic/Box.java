package ru.innopolis.uni.ivanov.generic;

/**
 * Created by i.viktor on 01/11/2016.
 */
public class Box<T extends Number> {
    private Box(){
        return;
    }

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void doSomething(int x, final int y) {
        x = Math.abs(y);
    }
}
