package ru.innopolis.uni.ivanov.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by i.viktor on 02/11/2016.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Dog dog = new Dog("Graf",40);

        try(FileOutputStream fileOutputStream = new FileOutputStream("./dog");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(dog);
            objectOutputStream.flush();
        }
    }

}
