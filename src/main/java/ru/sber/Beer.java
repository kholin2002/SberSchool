package ru.sber;

public class Beer implements Alcohol {

    @Override
    public String getName() {
        return "Пиво";
    }

    @Override
    public double getAvgVolume() {
        return (4.0 + 6.0) / 2;
    }
}
