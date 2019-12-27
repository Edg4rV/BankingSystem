package com.banking.account.manager;

import java.util.Arrays;

public class BankAccountManager implements AccountManager {
    private Account[] accounts;
    private int accountCounter;

    public BankAccountManager() {
        this.accounts = new Account[5555];
        this.accountCounter = 0;
    }


    @Override
    public void createNewAccount(Account account) {
        if (account != null) {
            this.accounts[accountCounter] = account;
            accountCounter++;
        }
    }

    @Override
    public void deleteAccount(Account account) {
        if (account == null) {
            System.out.println("warn: can not delete account which is null or empty");
            return;
        }

        for (int i = 0; i < this.accounts.length; i++) {
            if (accounts[i].equals(account)) {
                //if found such an element remove it, and resize array by skipping this null value
                accounts[i] = null;
                this.accountCounter--;
                this.accounts = createNewArray(this.accounts, i);
            }
        }
    }


    @Override
    public Account searchAccount(String accountNumber) {
        if (accountNumber == null || accountNumber.equals("")) {
            System.out.println("warn: can not search account having empty accountNumber");
            return null;
        }

        for (int i = 0; i < this.accounts.length; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }

        return null;
    }


    private static Account[] createNewArray(Account[] original, int indexToSkip) {
        for (int i = indexToSkip; i < original.length - 1; i++) {
            original[i] = original[i + 1];
        }

        return Arrays.copyOf(original, original.length - 1);
    }

    @Override
    public String toString() {
        return "MyAccountManager{" +
                "accounts=" + Arrays.toString(accounts) +
                ", accountCounter=" + accountCounter +
                '}';
    }
}
