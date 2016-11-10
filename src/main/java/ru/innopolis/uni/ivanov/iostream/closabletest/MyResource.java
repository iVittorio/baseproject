package ru.innopolis.uni.ivanov.iostream.closabletest;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by i.viktor on 02/11/2016.
 */
public class MyResource implements Closeable {


    @Override
    public void close() throws IOException {
        System.out.println("!!! Close method !!!" + toString());
        throw new RuntimeException("Close_Exception");
    }
}
