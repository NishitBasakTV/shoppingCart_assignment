package com.items;

import com.shoppingcart.Item;

public class Milk extends Item {
    private static final String MILK_TITLE = "Milk";
    private static final int MILK_SKU = 2;
    private static final double MILK_PRICE = 30;

    public Milk(int qty) {
        super(MILK_TITLE, qty, MILK_PRICE, MILK_SKU);
    }
}
