package com.items;

import com.shoppingcart.Item;

public class Apple extends Item {
    private static final String APPLE_TITLE = "Apple";
    private static final int APPLE_SKU = 1;
    private static final double APPLE_PRICE = 15;

    public Apple(int qty) {
        super(APPLE_TITLE, qty, APPLE_PRICE, APPLE_SKU);
    }
}
