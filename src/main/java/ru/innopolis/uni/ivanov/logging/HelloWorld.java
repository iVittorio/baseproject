package ru.innopolis.uni.ivanov.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by i.viktor on 10/11/2016.
 */
public class HelloWorld {
    public static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        logger.error("some");
    }
}
