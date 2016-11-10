package ru.innopolis.uni.ivanov.reflection;

import java.lang.reflect.*;

/**
 * Created by i.viktor on 08/11/2016.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Object proxy = Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{InterfaceOne.class}, new InvocationHandler() {
                    private InterfaceOneImpl interfaceOne = new InterfaceOneImpl();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("logging " + args);
                        return method.invoke(interfaceOne, args);
                    }
                });

        InterfaceOne one = (InterfaceOne) proxy;

        one.doSome(5);

        System.out.println(proxy);
    }
}
