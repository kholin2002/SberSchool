package ru.sber;

public class Vodka implements Alcohol {

    @Override
    public double getAvgVolume() {
        return 40;
    }

    @Override
    public String getName() {
        return "Водка";
    }
}
