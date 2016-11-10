package ru.innopolis.uni.ivanov.multithreading.cutnumberone;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by i.viktor on 08/11/2016.
 */
public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> sharedMap = new HashMap<>();
        int seconds = 1;

        Box box = new Box(sharedMap, false, seconds);

        Thread generator = new ThreadGenerator(box);
        Thread printer = new ThreadPrinter(box);

        generator.start();
        printer.start();


    }
}
