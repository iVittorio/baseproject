package ru.innopolis.uni.ivanov.serialization;


import java.io.Serializable;

/**
 * Created by i.viktor on 02/11/2016.
 */
public class Dog extends Pet implements Serializable {
    private transient final String name;
    private final int weight;


    public Dog(String name, int weight) {
        super(5);
        this.name = name;
        this.weight = weight;
    }

    public void bark(){

    }
}
