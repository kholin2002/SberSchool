package ru.sber;

import java.util.HashMap;

public class Cocktail implements Alcohol {

    private final HashMap<Drink, Integer> ingredients;
    private String name;

    public Cocktail(String name) {
        this.name = name;
        ingredients = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public double getAvgVolume() {
        double totalVolume = 0.0;
        int totalMl = 0;
        for (Drink drink : ingredients.keySet()) {
            double volume = 0.0;
            if (drink instanceof Alcohol) {
                volume = ((Alcohol) drink).getAvgVolume();
            }
            double k = (double) totalMl / (totalMl + ingredients.get(drink));
            totalVolume = totalVolume * k + volume * (1 - k);
            totalMl += ingredients.get(drink);
        }
        return totalVolume;
    }

    public void mixDrink(Drink drink, int amount) {
        ingredients.put(drink, amount);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Коктейль \"" + name + "\":");
        for (Drink drink : ingredients.keySet()) {
            s.append("\n");
            s.append(drink.getName());
            s.append(" ");
            s.append(ingredients.get(drink));
            s.append(" мл.");
        }
        s.append("\nПриблизительная крепость: ");
        s.append(String.format("%.2f%%", getAvgVolume()));
        return s.toString();
    }
}
