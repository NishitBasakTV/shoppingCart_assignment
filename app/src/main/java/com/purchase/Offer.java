package com.purchase;

import com.items.Milk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer {

    public static final double DISCOUNT_RATE = 5.0;
    public static final double MIN_AMOUNT_FOR_DISCOUNT = 100.0;
    public boolean IS_OFFER_ACTIVE = true;

    public static void checkCurrentOffer() {
        System.out.printf("Avail %.2f%% discount on total amount while purchase over %.2f", DISCOUNT_RATE, MIN_AMOUNT_FOR_DISCOUNT);
        System.out.println("Buy 2Litre of milk and get 1 free");
    }

    public static List<List> checkOfferOnQty(){
        List<List> offerPack = new ArrayList<>();
        /**
         * Format of offer is Arrays.asList(sku, buyingQty, freeQty)
         */
        List<Integer> milkOffer = new ArrayList<>(Arrays.asList(2,4,1));
        offerPack.add(milkOffer);
        return offerPack;
    }


}
