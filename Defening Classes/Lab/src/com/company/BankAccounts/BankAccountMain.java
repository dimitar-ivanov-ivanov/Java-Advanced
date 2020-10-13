package com.company.BankAccounts;

import com.company.BankAccounts.BankAccount;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> bankAccounts = new ArrayList<>();
        String[] bankArgs = scanner.nextLine().split(" ");
        String command = bankArgs[0];

        while (!command.equals("End")) {
            int id;
            switch (command) {
                case "Create":
                    createNewBankAccount(bankAccounts);
                    break;
                case "Deposit":
                    id = Integer.parseInt(bankArgs[1]);
                    double amount = Double.parseDouble(bankArgs[2]);
                    setDeposit(bankAccounts, id, amount);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(bankArgs[1]);
                    setNewInterestRateForAllAccounts(bankAccounts, interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(bankArgs[1]);
                    int years = Integer.parseInt(bankArgs[2]);
                    getTotalInterestOfAccount(bankAccounts, id, years);
                    break;
                default:
                    break;
            }

            bankArgs = scanner.nextLine().split(" ");
            command = bankArgs[0];
        }
    }

    private static void getTotalInterestOfAccount(List<BankAccount> bankAccounts, int id, int years) {
        if (id > bankAccounts.size()) {
            System.out.println("Account does not exist");
        } else {
            DecimalFormat df = new DecimalFormat("0.00");
            BankAccount account = bankAccounts.get(id - 1);
            double total = account.getBalance() * account.getInterestRate() * years;
            System.out.println(df.format(total));
        }
    }

    private static void setNewInterestRateForAllAccounts(List<BankAccount> bankAccounts, double interest) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            bankAccounts.get(i).setInterestRate(interest);
        }
    }

    private static void setDeposit(List<BankAccount> bankAccounts, int id, double amount) {
        if (id > bankAccounts.size()) {
            System.out.println("Account does not exist");
        } else {
            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
            DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);
            bankAccounts.get(id - 1).deposit(amount);
            System.out.println("Deposited " + df.format(amount) + " to ID" + id);
        }
    }

    private static void createNewBankAccount(List<BankAccount> bankAccounts) {
        bankAccounts.add(new BankAccount());
        System.out.println("Account ID" + bankAccounts.size() + " created");
    }
}
