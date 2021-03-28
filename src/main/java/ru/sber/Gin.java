package ru.sber;

public class Gin implements Alcohol {

    public double getAvgVolume() {
        return (37.5 + 50.0) / 2;
    }

    public String getName() {
        return "Джин";
    }
}
