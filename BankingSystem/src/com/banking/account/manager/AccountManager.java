package com.banking.account.manager;

public interface AccountManager {
    void createNewAccount(Account account);

    void deleteAccount(Account account);

    Account searchAccount(String accountNumber);

}
