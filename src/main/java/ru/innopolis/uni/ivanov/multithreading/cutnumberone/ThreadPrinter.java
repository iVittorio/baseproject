package ru.innopolis.uni.ivanov.multithreading.cutnumberone;

import java.util.Map;

/**
 * Created by i.viktor on 08/11/2016.
 */
public class ThreadPrinter extends Thread {
    private final Box box;

    public ThreadPrinter(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (!isInterrupted() && !box.isFinish()) {
            synchronized (box.getSharedMap()) {
                try {
                    box.getSharedMap().wait();
                    printMap();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void printMap() {
        if (box.getSeconds() % 5 == 0) {
            int finalKey = 0;
            int finalValue = 0;
            for (Map.Entry<Integer, Integer> pair : box.getSharedMap().entrySet()) {
                int key = pair.getKey();
                int value = pair.getValue();
                System.out.println("key: " + key + " value: " + value);
                if (value == 5) {
                    finalKey = key;
                    finalValue = value;
                    box.setFinish(true);
                }
            }
            if (finalValue != 0) {
                System.out.println("Число " + finalKey + ", встретилось " + finalValue + " раз. Программа остановлена.");
            }
        }
    }
}
