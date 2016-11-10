

package ru.innopolis.uni.ivanov.exception;


import java.io.IOException;

/**
 * Created by i.viktor on 01/11/2016.
 */
public class Test {

    public static void main(String[] args) {
        Main main = new Main();
        try {
            System.out.println(main.doSome(5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

