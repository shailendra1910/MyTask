package com.shop.basket;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.basket.CalculatePrice;
import com.basket.ShoppingBasket;
import com.shop.ItemInformation;
import com.shop.ItemInformationImpl;

/**
 * Tests the Calculate Price functionality
 */
public class CalculatePriceTest {

    private CalculatePrice calculatePrice;

    @Before
    public void setUp() throws Exception {
        calculatePrice = new CalculatePrice();

    }

    @Test
    public void getTotalPriceWithNoItems() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        BigDecimal actual = calculatePrice.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(0,new MathContext(2, RoundingMode.HALF_EVEN));
        assertTrue("Price should be 0",actual.compareTo(expected) == 0 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTotalPriceWithNullItems() throws Exception {
        BigDecimal price = calculatePrice.getTotalPrice(null);
    }

    @Test
    public void getTotalPriceWithOneItem() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ItemInformation item = new ItemInformationImpl("Banana",0.60);
        basket.addItem(item);

        BigDecimal actual = calculatePrice.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(0.60,new MathContext(2, RoundingMode.HALF_EVEN));
        assertTrue("Price should be 0.60",actual.compareTo(expected) == 0 );
    }

    @Test
    public void getTotalPriceWith1Item3Quanity() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        String name = "Banana";
        double price = 0.60;
        ItemInformation item1 = new ItemInformationImpl(name,price);
        ItemInformation item2 = new ItemInformationImpl(name,price);
        ItemInformation item3 = new ItemInformationImpl(name,price);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);

        BigDecimal expected = new BigDecimal(1.80,new MathContext(2, RoundingMode.HALF_EVEN));
        BigDecimal actual = calculatePrice.getTotalPrice(basket);

        assertTrue("Price should be 1.80", actual.compareTo(expected) == 0 );
    }

    @Test
    public void getTotalPriceWith3ItemQuanity1each() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ItemInformation item1 = new ItemInformationImpl("Banana",0.60);
        ItemInformation item2 = new ItemInformationImpl("Apple",0.50);
        ItemInformation item3 = new ItemInformationImpl("Orange",0.40);
        ItemInformation item4 = new ItemInformationImpl("Lemon",0.20);
        ItemInformation item5 = new ItemInformationImpl("Peaches",0.10);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);
        basket.addItem(item5);

        BigDecimal actual = calculatePrice.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(1.80,new MathContext(2, RoundingMode.HALF_EVEN));
        //banana -0.60, apple -0.50, orange - 0.40 lemon -0.20 peaches -0.10
        assertTrue("Price should be 1.80", actual.compareTo(expected) == 0 );

    }

    @Test
    public void getTotalPriceWithMultiItemMultiQuanity() throws Exception {
        ShoppingBasket basket = new ShoppingBasket();
        ItemInformation item1 = new ItemInformationImpl("Banana",0.60);
        ItemInformation item2 = new ItemInformationImpl("Apple",0.50);
        ItemInformation item3 = new ItemInformationImpl("Orange",0.40);
        ItemInformation item4 = new ItemInformationImpl("Banana",0.60);
        ItemInformation item5 = new ItemInformationImpl("Orange",0.40);
        ItemInformation item6 = new ItemInformationImpl("Orange",0.40);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        basket.addItem(item4);
        basket.addItem(item5);
        basket.addItem(item6);

        BigDecimal actual = calculatePrice.getTotalPrice(basket);
        BigDecimal expected = new BigDecimal(2.90,new MathContext(2, RoundingMode.HALF_EVEN));
        //banana -0.60, apple -0.50, orange - 0.40

        assertTrue("Price should be 2.90", actual.compareTo(expected) == 0 );

    }
}