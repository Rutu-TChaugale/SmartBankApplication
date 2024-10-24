package com.rutu.controller;

public class BankApplication {
    
    private static double balance = 100000; 
    private static String pin = "1234"; 
    private static String lastTransaction = ""; 

    public static void checkBalance() {
        System.out.println("Available balance is: " + balance);
    }

    public static void deposit(double depmoney) {
        balance += depmoney; 
        lastTransaction = "Deposited: " + depmoney; 
        System.out.println("After deposit, balance is: " + balance);
    }

    public static void withdraw(double withmoney) {
        balance -=withmoney; 
        lastTransaction = "Withdrew: " + withmoney; 
        System.out.println("After withdrawal, balance is: " + balance);
    }

    public static double getBalance() {
        return balance; 
    }

    public static void transferFunds(double transferAmount, String toAccount) {
        balance -=transferAmount; 
        lastTransaction = "Transferred: " + transferAmount + " to account: " + toAccount;
        System.out.println("Transferred " + transferAmount + " to account: " + toAccount);
        System.out.println("New balance is: " + balance);
    }

    public static void printReceipt() {
        System.out.println("\n<------Transaction Receipt------->");
        if (lastTransaction.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println(lastTransaction); 
        }
    }

    public static void changePin(String newPin) {
        pin = newPin;
        System.out.println("PIN changed successfully.");
    }
}
