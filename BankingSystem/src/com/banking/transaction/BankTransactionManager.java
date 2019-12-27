package com.banking.transaction;

import com.banking.account.manager.Account;

public class BankTransactionManager implements TransactionManager {
    private Transaction[] bankTransactions;
    private int transactionCounter;

    public BankTransactionManager() {
        this.bankTransactions = new BankTransaction[5555];
        this.transactionCounter = 0;
    }


    @Override
    public void withdraw(Account accountToWithdraw, double amount) {
        double balance = accountToWithdraw.getBalance();

        if (balance >= amount) {
            balance -= amount;
            accountToWithdraw.setBalance(balance);
            BankTransaction withdraw = new BankTransaction("withdraw", accountToWithdraw);
            withdraw.setDescription("Made withdraw in amount: " + amount + " for account: " + accountToWithdraw.getAccountNumber());

            this.bankTransactions[transactionCounter] = withdraw;
            transactionCounter++;
        }
    }

    @Override
    public void deposit(Account accountToFill, double amount) {
        double balance = accountToFill.getBalance();
        balance += amount;
        accountToFill.setBalance(balance);

        BankTransaction deposit = new BankTransaction("deposit", accountToFill);
        deposit.setDescription("Made deposit in amount: " + amount + " for account: " + accountToFill.getAccountNumber());

        this.bankTransactions[transactionCounter] = deposit;
        transactionCounter++;
    }


    @Override
    public void transfer(Account from, Account to, double amount) {
        if (from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            BankTransaction transfer = new BankTransaction("transfer", from, to);
            transfer.setDescription("Made transfer in amount: " + amount + " from account: " + from.getAccountNumber() + " to account: " + to.getAccountNumber());

            this.bankTransactions[transactionCounter] = transfer;
            transactionCounter++;
        }
    }

    @Override
    public Transaction[] getAllTransactions() {
        return this.bankTransactions;
    }
}
