package com.basket;

import java.util.HashMap;

import com.shop.ItemInformation;

/**
 * Class to manage the shopping items
 */
public class ShoppingBasket {

    // map of items to their quantity
    private HashMap<ItemInformation, Integer> items;

    public HashMap<ItemInformation, Integer> getItems() {
        return items;
    }

    public ShoppingBasket(){
        items = new HashMap<>();
    }


    /**
     * Adds an item with a inital quantity of 1. if the item already exists, its quantity will be increase by 1
     * @param item shoppingitem to be added
     */
    public void addItem(ItemInformation item){
        if(item == null){
            throw new IllegalArgumentException("Shopping item can not be null");
        }

        if (items.containsKey(item)) {
            items.replace(item, items.get(item) + 1);
        } else {
            items.put(item,1);
        }
    }

    /**
     * Clears all items in the shopping basket
     */
    public void clear(){
        items.clear();
    }

}
