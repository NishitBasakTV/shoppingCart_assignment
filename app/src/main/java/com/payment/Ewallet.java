package com.payment;

public class Ewallet {

    private String userName;
    private double avlBalance;

    public Ewallet(String userName) {
        this.userName = userName;
        this.avlBalance=0.0;
    }

    public String getUserName() {
        return userName;
    }

    public double getAvlBalance() {
        return avlBalance;
    }

    public void addMoney(double amount){
        if (amount < 0) {
            System.out.println("Adding money to ewallet shouldn't be less than zero");
            System.exit(0);
        }
        avlBalance+=amount;

    }

    public void debitAmount(double amount){
        if (amount < 0) {
            System.out.println("Debit amount from ewallet shouldn't be less that zero");
            System.exit(0);
        }
        avlBalance-=amount;
    }
}
