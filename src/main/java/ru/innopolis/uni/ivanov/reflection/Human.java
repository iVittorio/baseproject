package ru.innopolis.uni.ivanov.reflection;

/**
 * Created by i.viktor on 08/11/2016.
 */
public class Human {
    private int money = 100;
    private String firstName = "Ivan";
    private String secondName = "Ivanov";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
