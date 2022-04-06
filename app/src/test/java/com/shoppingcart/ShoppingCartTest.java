package com.shoppingcart;

import com.items.Apple;
import com.items.Milk;
import com.items.Newspaper;
import com.payment.Ewallet;
import com.purchase.Offer;
import com.purchase.Purchase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingCartTest {
    /**
     * --steps to make a purchase
     * 1. Create item objects
     * 2. Create cart object and add all items to cart
     * 3. Create Wallet object and add money to wallet
     * 4. Create Purchase object and complete purchase
     */
    @Test
    void addToCartTest() {
        Cart cart = new Cart();
        Apple apple = new Apple(2);
        Newspaper newspaper = new Newspaper(1);

        cart.addToCart(apple);
        cart.addToCart(newspaper);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(cart.getCartItems().size(), 2);
        sa.assertEquals(cart.getCartItems().get(0).getQty(), 2);
        sa.assertEquals(cart.getCartItems().get(1).getQty(), 1);
//        System.out.println(cart.getCartItems());

        sa.assertAll();
    }

    @Test
    void removeFromCartTest() {
        Cart cart = new Cart();
        Apple apple = new Apple(2);
        Newspaper newspaper = new Newspaper(1);

        cart.addToCart(apple);
        cart.addToCart(newspaper);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(cart.getCartItems().size(), 2);
        sa.assertEquals(cart.getCartItems().get(0).getQty(), 2);
        sa.assertEquals(cart.getCartItems().get(1).getQty(), 1);

        cart.removeFromCart(newspaper);
        sa.assertEquals(cart.getCartItems().size(), 1);

        sa.assertAll();

        System.out.println(cart.getCartItems());
    }

    @Test(enabled = false)
    void testCurrentOffer() {
        Offer offer = new Offer();
        offer.checkCurrentOffer();

    }

    @Test
    void makePurchaseWithoutDiscount() {
        SoftAssert sa = new SoftAssert();
//        step-1
        Apple apple = new Apple(2);
        Newspaper newspaper = new Newspaper(1);
//        step-2
        Cart cart = new Cart();
        cart.addToCart(apple);
        cart.addToCart(newspaper);
//        step-3
        Ewallet ewallet = new Ewallet("testUser");
        double amount = 500.0;
        ewallet.addMoney(amount);
//        Assertion
        sa.assertEquals(ewallet.getAvlBalance(), amount);
//        step-4
        Purchase purchase = new Purchase(cart, ewallet);
        purchase.makePurchase();

        sa.assertEquals(ewallet.getAvlBalance(), amount-purchase.getFinalAmount());
        sa.assertAll();
    }

    @Test
    void makePurchaseWithBulkDiscount() {
        SoftAssert sa = new SoftAssert();
//        step-1
        Apple apple = new Apple(3);
        Milk milk = new Milk(2);
        Newspaper newspaper = new Newspaper(1);
//        step-2
        Cart cart = new Cart();
        cart.addToCart(apple);
        cart.addToCart(milk);
        cart.addToCart(newspaper);
//        step-3
        Ewallet ewallet = new Ewallet("testUser");
        ewallet.addMoney(500);
//        step-4
        Purchase purchase = new Purchase(cart, ewallet);
        purchase.makePurchase();

        sa.assertEquals(ewallet.getAvlBalance(), 392.65);
        sa.assertAll();
    }

    @Test
    void makePurchaseWithFreeItemDiscount() {
        SoftAssert sa = new SoftAssert();
//        step-1
        Apple apple = new Apple(1);
        Milk milk = new Milk(5);
        Newspaper newspaper = new Newspaper(1);
//        step-2
        Cart cart = new Cart();
        cart.addToCart(apple);
        cart.addToCart(milk);
        cart.addToCart(newspaper);
//        step-3
        Ewallet ewallet = new Ewallet("testUser");
        ewallet.addMoney(500);
//        step-4
        Purchase purchase = new Purchase(cart, ewallet);
        purchase.makePurchase();

        sa.assertEquals(ewallet.getAvlBalance(), 364.15);
        sa.assertAll();
    }
}
