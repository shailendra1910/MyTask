package com.basket;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

import com.shop.ItemInformation;

/**
 * Implements Calculate Price  functionality for the Item
 */
public class CalculatePrice {

    /**
     * Calculates the total price for the basket containing shopping items
     * @param basket - Shopping basket containing the items to check out
     * @return Big decimal representation of the total cost price for the basket
     */
    public BigDecimal getTotalPrice(ShoppingBasket basket){
        if(basket == null){
            throw new IllegalArgumentException("Shopping basket can not be null");
        }

        final Map<ItemInformation,Integer> items = basket.getItems();
        MathContext mc = new MathContext(2, RoundingMode.HALF_EVEN);
        //Sum of quantity * price for all items
        return basket.getItems()
                            .keySet()
                            .stream()
                            .map( item -> item.getPrice().multiply(new BigDecimal(items.get(item),mc)))
                            .reduce(BigDecimal.ZERO,BigDecimal::add);



    }



}
