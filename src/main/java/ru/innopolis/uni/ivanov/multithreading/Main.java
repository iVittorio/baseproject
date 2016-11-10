package ru.innopolis.uni.ivanov.multithreading;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by i.viktor on 03/11/2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Box box = new Box(0);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new MyThread(box));
        }

        threads.forEach(Thread::start);

        for (Thread t : threads) t.join();

        System.out.println(box.getValue());
    }
}
