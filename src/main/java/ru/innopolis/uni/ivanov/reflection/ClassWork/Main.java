package ru.innopolis.uni.ivanov.reflection.ClassWork;

/**
 * Created by i.viktor on 08/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        PrimitiveObject objectBefore = new PrimitiveObject();
        objectBefore.setaBoolean(true);
        objectBefore.setaByte((byte) 4);
        objectBefore.setaChar('c');
        objectBefore.setaDouble(5.6);
        objectBefore.setaFloat(1.5F);
        objectBefore.setaLong(100L);
        objectBefore.setAnInt(500);
        objectBefore.setaShort((short) 6);

        XMLUtils XMLUtils = new XMLUtils();

        XMLUtils.serializeToXML(objectBefore, "./Text.xml");

        System.out.println("Before serialize\n" + objectBefore);

        Object object = XMLUtils.deserializeFromXml("./Text.xml");

        PrimitiveObject objectAfter = (PrimitiveObject) object;

        System.out.println("After serialize\n" + objectAfter);

        System.out.println(objectBefore.equals(objectAfter));
    }

}
