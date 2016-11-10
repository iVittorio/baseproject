package ru.innopolis.uni.ivanov.reflection.ClassWork;

/**
 * Created by i.viktor on 09/11/2016.
 */
public class PrimitiveObject {
    private int anInt;
    private long aLong;
    private short aShort;
    private double aDouble;
    private float aFloat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimitiveObject that = (PrimitiveObject) o;

        if (getAnInt() != that.getAnInt()) return false;
        if (getaLong() != that.getaLong()) return false;
        if (getaShort() != that.getaShort()) return false;
        if (Double.compare(that.getaDouble(), getaDouble()) != 0) return false;
        if (Float.compare(that.getaFloat(), getaFloat()) != 0) return false;
        if (getaChar() != that.getaChar()) return false;
        if (getaBoolean() != that.getaBoolean()) return false;
        return getaByte() == that.getaByte();

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getAnInt();
        result = 31 * result + (int) (getaLong() ^ (getaLong() >>> 32));
        result = 31 * result + (int) getaShort();
        temp = Double.doubleToLongBits(getaDouble());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getaFloat() != +0.0f ? Float.floatToIntBits(getaFloat()) : 0);
        result = 31 * result + (int) getaChar();
        result = 31 * result + (getaBoolean() ? 1 : 0);
        result = 31 * result + (int) getaByte();
        return result;
    }

    private char aChar;
    private boolean aBoolean;
    private byte aByte;


    @Override
    public String toString() {
        return "PrimitiveObject{" +
                "aBoolean=" + aBoolean +
                ", anInt=" + anInt +
                ", aLong=" + aLong +
                ", aShort=" + aShort +
                ", aDouble=" + aDouble +
                ", aFloat=" + aFloat +
                ", aChar=" + aChar +
                ", aByte=" + aByte +
                '}';
    }

    public boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public byte getaByte() {
        return aByte;
    }

    public void setaByte(byte aByte) {
        this.aByte = aByte;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public short getaShort() {
        return aShort;
    }

    public void setaShort(short aShort) {
        this.aShort = aShort;
    }


}
