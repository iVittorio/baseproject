package ru.innopolis.uni.ivanov.entity;

/**
 * Created by i.viktor on 01/11/2016.
 */
public class Skill {
    @Override
    public String toString() {
        return "Skill{" +
                "description='" + description + '\'' +
                ", level=" + level +
                '}';
    }

    private String description;
    private int level;

    public Skill(String description, int level) {
        this.description = description;
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
