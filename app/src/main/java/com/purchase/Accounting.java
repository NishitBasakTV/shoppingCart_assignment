package com.purchase;

import com.shoppingcart.Cart;
import com.shoppingcart.Item;

import java.util.List;

public class Accounting {

    private Cart cart;
    private double totalAmount;
    private double finalAmount;
    private double discount;
    private double discountForBulkPurchase;


    public Accounting(Cart cart) {
        this.cart = cart;
        totalAmount = 0;
        finalAmount = 0;
        discount = 0;
        discountForBulkPurchase = 0;
    }

    private static double calculateDiscountOnQty(Cart cart) {
        double discount = 0;
        List<List> offerPack = Offer.checkOfferOnQty();
        if (!offerPack.isEmpty()) {
            for (List offer : offerPack) {
                for (Item cartItem : cart.getCartItems()) {
                    if ((int) offer.get(0) == cartItem.getSku()) {
                        int qtyToGetFree = (int) offer.get(1) + 1;
                        int freeQty = (int) offer.get(2);

                        discount += cartItem.getQty() / qtyToGetFree * freeQty * cartItem.getPrice();
                    }
                }
            }
        }
        return discount;
    }

    private static double calculateDiscountOnTotal(double totalAmount) {
        double discountForBulkPurchase = 0;
        if (totalAmount >= Offer.MIN_AMOUNT_FOR_DISCOUNT) {
            discountForBulkPurchase = totalAmount * Offer.DISCOUNT_RATE / 100;
        }
        return discountForBulkPurchase;
    }

    public void calculateFinalAmount() {
        for (Item cartItem : cart.getCartItems()) {
            totalAmount += cartItem.getPrice() * cartItem.getQty();
        }
        System.out.println("totalAmount "+totalAmount);
        discount = Accounting.calculateDiscountOnQty(cart);
        totalAmount -= discount;
        System.out.println("totalAmount after deducting free item price "+totalAmount);
        discountForBulkPurchase = Accounting.calculateDiscountOnTotal(totalAmount);
        System.out.println("discountForBulkPurchase "+discountForBulkPurchase);
        finalAmount = totalAmount - discountForBulkPurchase;
        System.out.println("finalAmount "+finalAmount);
    }

    public double getFinalAmount() {
        return finalAmount;
    }
}
