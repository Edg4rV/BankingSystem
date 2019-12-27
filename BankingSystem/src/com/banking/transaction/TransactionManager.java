package com.banking.transaction;

import com.banking.account.manager.Account;

public interface TransactionManager {

    void withdraw(Account accountToWithdraw, double amount);

    void deposit(Account accountToFill, double amount);

    void transfer(Account from, Account to, double amount);

    Transaction[] getAllTransactions();
}

