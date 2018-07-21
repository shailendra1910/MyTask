package com.shop;

import java.math.BigDecimal;

/**
 * Represents a Item Info which can be shopped
 */
public interface ItemInformation {

    /**
     * Get the name of the item. This also acts as the key for now
     * @return the name of the item,which is also the key
     */
    String getName();

    /**
     * return the selling price of the item
     * @return the selling price of the item
     */
    BigDecimal getPrice();

}
