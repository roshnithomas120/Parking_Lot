package com.example.model;

public class Price {
    public enum Scheme {HOUR,FLAT,DAY,ADDUP};
    int startHour;
    int endHour;
    int fees;

    Scheme scheme;

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getFees() {
        return fees;
    }

    public Scheme getScheme() {
        return scheme;
    }

}
