package com.shop.basket;

import com.basket.ShoppingBasket;
import com.shop.ItemInformation;
import com.shop.ItemInformationImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shailendra on 21/07/2018.
 */
public class ShoppingBasketTest {

    private ShoppingBasket basket;
    @Before
    public void setUp() throws Exception {
        basket = new ShoppingBasket();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullItem() {
        basket.addItem(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void addItemWithEmptyName() {
        ItemInformation item  = new ItemInformationImpl("",0.60);
        basket.addItem(item);

    }

    @Test
    public void clearsAllItemsFromTheBasket() {
        ItemInformation item  = new ItemInformationImpl("Apple",0.60);
        basket.addItem(item);
        assertTrue(basket.getItems().size()>0);
        basket.clear();
        assertEquals("Basket must be empty",0,basket.getItems().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemWithNameAsBlankSpace() {
        ItemInformation item  = new ItemInformationImpl(" ",0.60);
        basket.addItem(item);
    }

    @Test
    public void addOneItem() {
        ItemInformation item  = new ItemInformationImpl("Apple",0.60);
        basket.addItem(item);

        assertEquals("Should have 1 item",1,basket.getItems().size());
    }

    @Test
    public void add2DifferentItems() {
        ItemInformation item1  = new ItemInformationImpl("Apple",0.60);
        ItemInformation item2  = new ItemInformationImpl("banana",0.40);
        basket.addItem(item1);
        basket.addItem(item2);

        assertEquals("Should have 1 item",2,basket.getItems().size());
    }

    @Test
    public void add2ItemsOfSameType() {
        ItemInformation item1  = new ItemInformationImpl("Apple",0.60);
        ItemInformation item2  = new ItemInformationImpl("Apple",0.60);
        basket.addItem(item1);
        basket.addItem(item2);

        assertEquals("Should have 1 item with qty as 2",1,basket.getItems().size());
        assertEquals("Should have 1 item with qty as 2",new Integer(2),basket.getItems().get(item1));
    }
}