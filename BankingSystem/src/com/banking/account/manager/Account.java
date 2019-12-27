package com.banking.account.manager;

public interface Account {
    String getAccountNumber();

    String getName();

    String getSurname();

    double getBalance();

    void setBalance(double balance);
}
