package ru.innopolis.uni.ivanov.exception;

import java.io.IOException;

/**
 * Created by i.viktor on 02/11/2016.
 */
public class Main {
    public int doSome(int a) throws IOException {
        Exception exception = null;

        ExceptionThrower exceptionThrower = new ExceptionThrower();
        try {
            exceptionThrower.throwEx();
            System.out.println("It is a try block!");
        } catch (IOException e) {
            System.out.println("It is a catch block!");
            exception = e;
            StackTraceElement[] trace = e.getStackTrace();
            throw e;
        } finally {
            System.out.println("It is a finally block!");
            throw new RuntimeException(exception);
        }
        //return a;
    }
}
