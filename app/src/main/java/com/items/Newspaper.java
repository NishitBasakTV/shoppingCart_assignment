package com.items;

import com.shoppingcart.Item;

public class Newspaper extends Item {
    private static final String NEWSPAPER_TITLE = "Newspaper";
    private static final int NEWSPAPER_SKU = 3;
    private static final double NEWSPAPER_PRICE = 8;

    public Newspaper(int qty) {
        super(NEWSPAPER_TITLE, qty, NEWSPAPER_PRICE, NEWSPAPER_SKU);
    }
}
