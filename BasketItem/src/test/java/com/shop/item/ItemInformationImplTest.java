package com.shop.item;

import org.junit.Test;

import com.shop.ItemInformation;
import com.shop.ItemInformationImpl;

import static org.junit.Assert.*;

/**
 * Created by Shailendra on 21/07/2018.
 */
public class ItemInformationImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithNullNameAndPrice() {
        ItemInformation item = new ItemInformationImpl(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithNullNameAndValidPrice() {
        ItemInformation item = new ItemInformationImpl(null,0.10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithValidNameAndNullPrice() {
        ItemInformation item = new ItemInformationImpl("Test",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithEmptyNameAndValidPrice() {
        ItemInformation item = new ItemInformationImpl("",0.10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemWithBlankSpaceNameAndPrice() {
        ItemInformation item = new ItemInformationImpl(" ",0.10);
    }


    @Test
    public void testEquals() throws Exception {
        ItemInformation item1 = new ItemInformationImpl("Apple",0.10);
        ItemInformation item2 = new ItemInformationImpl("Apple",0.10);
        ItemInformation item3 = new ItemInformationImpl("apple",0.10);

        assertEquals("Items should be equal",item1,item2);
        assertEquals("Items should be equal",item3,item2);
    }

    @Test
    public void testHashCode() throws Exception {
        ItemInformation item1 = new ItemInformationImpl("Apple",0.10);
        ItemInformation item2 = new ItemInformationImpl("Apple",0.10);
        ItemInformation item3 = new ItemInformationImpl("apple",0.10);

        assertEquals("Items should be equal",item1.hashCode(),item2.hashCode());
        assertEquals("Items should be equal",item3.hashCode(),item2.hashCode());
    }

}