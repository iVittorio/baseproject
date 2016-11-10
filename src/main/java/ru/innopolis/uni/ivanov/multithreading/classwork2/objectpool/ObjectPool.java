package ru.innopolis.uni.ivanov.multithreading.classwork2.objectpool;

import java.util.*;

/**
 * Created by i.viktor on 07/11/2016.
 * Необходимо разработать пул объектов. Скоуп требований:
 * 1. Возможность получить объект с помощью вызова getObject()
 * 2. Возможность вернуть объект в пул
 * 3. Возможность задания размерности пула. При превышении размерности новые объекты не должны создаваться, а вызывающий поток должен быть переведен в ожидание. По истечении таймаута, если объект не был выдан, то выбрасывается PoolException
 * 4. Возможность задания таймаута, в течении которого поток может ожидать возвращения объекта
 */
public class ObjectPool {
    private int size;
    private long timeout = 5_000;
    private final List<Object> inUse = new LinkedList<>();
    private final List<Object> available = new LinkedList<>();

    /**
     * Creates and return a new object if not available or return available.
     * Throw PoolException if after the timeout there is no available objects
     *
     * @return a new object if not available or return available
     * @throws PoolException throws if after the timeout there is no available objects
     */
    public synchronized Object getObject() throws PoolException {
        if (size == inUse.size()) {
            long sleepTime = System.currentTimeMillis();
            while (available.isEmpty()) {
                if (System.currentTimeMillis() - sleepTime < timeout) {
                    try {
                        this.wait(timeout);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else throw new PoolException();
            }
        }
        if (available.isEmpty()) {
            Object newObj = new Object();
            inUse.add(newObj);
            return newObj;
        } else {
            Object inUseObj = available.remove(0);
            inUse.add(inUseObj);
            return inUseObj;
        }
    }

    /**
     * Adds the object in ObjectPool. If number object free and used should be less then size of ObjectPool
     *
     * @param obj the object for add to ObjectPool
     */
    public synchronized void returnObject(Object obj) {
        if (size >= (available.size() + inUse.size()) && size != 0) {
            available.add(obj);
            inUse.remove(obj);
            this.notifyAll();
        } else System.out.println(Thread.currentThread().getName() + " " + obj + " doesn't added");
    }

    /**
     * Sets the size of the ObjectPool. If number is default then can't add an object.
     * Method getObject after timeout throw PoolException.
     *
     * @param size the size of the ObjectPool. Default equals 0.
     */
    public synchronized void setSize(int size) {
        this.size = size;
    }

    /**
     * Sets the timeout of the ObjectPool. Upon expiry timeout method getObject throw PoolException
     *
     * @param timeout the waiting time of the object in milliseconds. Default number is 5000 mills
     */
    public synchronized void setTimeout(long timeout) {
        this.timeout = timeout;
    }

}
