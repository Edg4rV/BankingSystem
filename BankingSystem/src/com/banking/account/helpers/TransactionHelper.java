package com.banking.account.helpers;

import java.util.Scanner;

public class TransactionHelper {


    public double askAmount(String purpose) {
        System.out.println("Please Enter amount for " + purpose);
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        if (amount == 0.0d || amount < 0) {
            System.out.println("warn: invalid amount please enter correct one..");
            return askAmount(purpose);
        } else {
            return amount;
        }
    }
}
