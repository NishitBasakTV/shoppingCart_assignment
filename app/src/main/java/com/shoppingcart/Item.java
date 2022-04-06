package com.shoppingcart;

public class Item {

    private String title;
    private int qty;
    private double price;
    private int sku;

    public Item(String title, int qty, double price, int sku) {
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Item{" + "title='" + title + '\'' + ", qty=" + qty + ", price=" + price + ", sku=" + sku + '}';
    }
}
