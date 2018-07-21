package com.shop;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Concrete implementation of the Item Information interface
 */
public class ItemInformationImpl implements ItemInformation {
    private String name;
    private BigDecimal price;

    public ItemInformationImpl(String name,Double price){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Item name can not be null or empty");
        }
        if(price == null || price < 0.0){
            throw new IllegalArgumentException("Item price can not be null or less than 0.0");
        }

        this.name = name.toUpperCase();
        this.price = new BigDecimal(price,new MathContext(2, RoundingMode.HALF_EVEN));

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemInformationImpl that = (ItemInformationImpl) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
