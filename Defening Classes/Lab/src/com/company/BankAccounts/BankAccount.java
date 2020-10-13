package com.company.BankAccounts;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private int id;
    private double balance;
    private double interestRate;
    public static int bankAccountCount;

    public BankAccount() {
        this.id = ++bankAccountCount;
        this.balance = 0;
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
