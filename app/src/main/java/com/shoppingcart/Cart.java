package com.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String userName;
    private List<Item> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addToCart(Item item) {
        Boolean addedToCart = false;
        for (Item existingItem : cartItems) {
            if (item.getSku() == existingItem.getSku()) {
                existingItem.setQty(existingItem.getQty() + 1);
                addedToCart = true;
            }
        }
        if (!addedToCart)
            cartItems.add(item);
    }

    public void removeFromCart(Item item) {
        cartItems.remove(item);
    }

    public void changeItemPrice(Item item, int newPrice) {
        if (newPrice < 0) {
            System.out.println("Price shouldn't be less that zero");
            return;
        }
        Boolean flag = false;
        for (Item existingItem : cartItems) {
            if (item.getSku() == existingItem.getSku()) {
                existingItem.setPrice(newPrice);
                flag = true;
            }
        }
        if (!flag)
            System.out.println("No item found in cart");
    }

    public void changeItemQty(Item item, int newQty) {
        if (newQty < 0) {
            System.out.println("Quantity shouldn't be less that zero");
            return;
        } else if (newQty == 0) {
            this.removeFromCart(item);
            return;
        }
        Boolean flag = false;
        for (Item existingItem : cartItems) {
            if (item.getSku() == existingItem.getSku()) {
                existingItem.setQty(newQty);
                flag = true;
            }
        }
        if (!flag)
            System.out.println("No item found in cart");
    }

    public List<Item> getCartItems() {
        return cartItems;
    }
}
