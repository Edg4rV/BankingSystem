package com.banking.transaction;

import com.banking.account.manager.Account;

public class BankTransaction implements Transaction {

    private String name;
    private Account targetAccount;
    private Account toAccount;
    private String description;

    public BankTransaction(String name, Account targetAccount) {
        this.name = name;
        this.targetAccount = targetAccount;
    }

    public BankTransaction(String name, Account targetAccount, Account toAccount) {
        this.name = name;
        this.targetAccount = targetAccount;
        this.toAccount = toAccount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Account getTargetAccount() {
        return targetAccount;
    }

    @Override
    public Account getToAccount() {
        return toAccount;
    }

    @Override
    public String getTransactionDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
