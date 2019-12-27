package com.banking.account.helpers;

import com.banking.account.manager.Account;
import com.banking.account.manager.BankAccount;

import java.util.Scanner;

public class AccountHelper {


    public Account createAccountObjectByAskinConsole() {
        System.out.println("Creating new account...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of card holder");
        String name = sc.next();
        System.out.println("Enter surname of card holder");
        String surname = sc.next();

        return new BankAccount(name, surname);
    }


    public String askAccountUniqueId() {
        System.out.println("Enter account number:");
        Scanner sc = new Scanner(System.in);
        String targetAccountNumber = sc.next();

        if (targetAccountNumber == null || targetAccountNumber.equals("")) {
            System.out.println("warn: invalid account number, please enter correct one..");
            return askAccountUniqueId();
        } else {
            return targetAccountNumber;
        }
    }
}
