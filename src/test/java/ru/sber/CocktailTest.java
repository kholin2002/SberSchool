package ru.sber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CocktailTest {

    private Cocktail cocktail;

    @Before
    public void setUp() {
        cocktail = new Cocktail("Mockito");
    }

    @Test
    public void getAvgVolume() {
        Alcohol drink1 = Mockito.mock(Alcohol.class);
        Mockito.when(drink1.getAvgVolume()).thenReturn(70.0);
        Alcohol drink2 = Mockito.mock(Alcohol.class);
        Mockito.when(drink2.getAvgVolume()).thenReturn(20.0);
        Drink drink3 = Mockito.mock(Drink.class);
        cocktail.mixDrink(drink1, 20);
        cocktail.mixDrink(drink2, 40);
        cocktail.mixDrink(drink3, 100);
        Assert.assertEquals(13.75, cocktail.getAvgVolume(), 0.01);
    }
}