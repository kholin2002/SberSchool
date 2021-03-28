package ru.sber;

public class Application {

    public static void main(String[] args) {
        Cocktail c = new Cocktail("Кровавая Мэри");
        c.mixDrink(new Vodka(), 45);
        c.mixDrink(new Juice("Томатный сок"), 90);
        c.mixDrink(new Juice("Лимонный сок"), 15);
        System.out.println(c);
    }
}
