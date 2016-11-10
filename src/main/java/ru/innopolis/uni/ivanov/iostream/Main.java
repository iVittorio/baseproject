package ru.innopolis.uni.ivanov.iostream;

import ru.innopolis.uni.ivanov.iostream.closabletest.MyResource;

import java.io.*;

/**
 * Created by i.viktor on 02/11/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        MyResource resource = new MyResource();

        try (MyResource myResource = new MyResource();
        MyResource myResource1 = null;
        MyResource myResource2 = new MyResource();
        MyResource myResource3 = resource) {
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            throw new RuntimeException("Some");
        }
    }
}
