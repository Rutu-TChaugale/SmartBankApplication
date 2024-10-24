package com.rutu.client;

import java.util.Scanner;
import com.rutu.controller.BankApplication;

public class BankTestApplication {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        
        while(flag){
            System.out.println("\n<------Welcome to Smart Bank Application------->");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Print Receipt");
            System.out.println("6. Change PIN");
            System.out.println("7. Exit");
            System.out.print("Enter Your choice: ");
            
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    BankApplication.checkBalance();
                    break;
                    
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    if (depositAmount <= 0) {
                        System.out.println("Deposit amount must be positive.");
                    } else {
                        BankApplication.deposit(depositAmount);
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Withdrawal amount must be positive.");
                    } else if (withdrawAmount > BankApplication.getBalance()) {
                        System.out.println("Insufficient funds for this withdrawal.");
                    } else {
                        BankApplication.withdraw(withdrawAmount);
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter the amount to transfer: ");
                    double transferAmount = sc.nextDouble();
                    if (transferAmount <= 0) {
                        System.out.println("Transfer amount must be positive.");
                    } else if (transferAmount > BankApplication.getBalance()) {
                        System.out.println("Insufficient funds for this transfer.");
                    } else {
                        System.out.print("Enter the account number to transfer to: ");
                        String accountNumber = sc.next();
                        BankApplication.transferFunds(transferAmount, accountNumber);
                    }
                    break;

                case 5:
                    BankApplication.printReceipt();
                    break;

                case 6:
                    System.out.print("Enter new PIN: ");
                    String newPin = sc.next();
                    BankApplication.changePin(newPin);
                    break;

                case 7:
                    System.out.println("Thank you for using Smart Bank Application. Goodbye!");
                    flag = false; 
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close(); 
    }
}

