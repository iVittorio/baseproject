package ru.innopolis.uni.ivanov.reflection;

/**
 * Created by i.viktor on 08/11/2016.
 */
public class InterfaceOneImpl implements InterfaceOne {

    private int field;
    @Override
    public void doSome(int arr) {
        System.out.println("InterfaceOneImpl calling!!!");
        this.field = arr;
    }
}
