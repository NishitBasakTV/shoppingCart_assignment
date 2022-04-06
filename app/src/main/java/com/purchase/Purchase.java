package com.purchase;

import com.payment.Ewallet;
import com.shoppingcart.Cart;

public class Purchase {

    private Cart cart;
    private Ewallet ewallet;
    private Accounting accounting;
    private double finalAmount;

    public Purchase(Cart cart, Ewallet ewallet) {
        this.cart = cart;
        this.ewallet = ewallet;
        accounting = new Accounting(cart);
    }

    public void makePurchase() {
        if (ewallet.getAvlBalance() < accounting.getFinalAmount()) {
            System.out.println("You don't have sufficient balance to make this purchase. Please add money to your eWallet");
            return;
        }

        System.out.println("Wallet Balance:" + ewallet.getAvlBalance());
        accounting.calculateFinalAmount();
        finalAmount = accounting.getFinalAmount();
        ewallet.debitAmount(finalAmount);
        System.out.println("Your purchase is completed");
        System.out.println("Wallet Balance:" + ewallet.getAvlBalance());

    }

    public double getFinalAmount() {
        return finalAmount;
    }
}
