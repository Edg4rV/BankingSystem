package com.banking.console;

import com.banking.account.helpers.AccountHelper;
import com.banking.account.manager.Account;
import com.banking.account.manager.AccountManager;

import java.util.Scanner;

public class ConsoleAccountProcessing {
    private AccountManager accountManager;
    private AccountHelper accountHelper;

    public ConsoleAccountProcessing(AccountManager accountManager) {
        this.accountManager = accountManager;
        this.accountHelper = new AccountHelper();
    }


    public boolean processAccountRelatedActions() {
        System.out.println("******** Choose Action ********");
        System.out.println("1: Create new account");
        System.out.println("2: Remove existing account");
        System.out.println("3: Search existing account");

        Scanner sc = new Scanner(System.in);
        int chosenOperation = sc.nextInt();

        if (chosenOperation != 1 && chosenOperation != 2 && chosenOperation != 3) {
            System.out.println("invalid operation, please chose correct one...");
            return processAccountRelatedActions();
        } else {

            switch (chosenOperation) {
                case 1:
                    return createNewAccount();

                case 2:
                    return terminateAccount();

                case 3:
                    return printAccountDetails();

                default:
                    return false;
            }
        }
    }


    private boolean createNewAccount() {
        Account newAccount = accountHelper.createAccountObjectByAskinConsole();
        accountManager.createNewAccount(newAccount);
        System.out.println("created account number: " + newAccount.getAccountNumber());
        return true;
    }


    private boolean terminateAccount() {
        String accountNumber = accountHelper.askAccountUniqueId();
        Account foundAccount = accountManager.searchAccount(accountNumber);

        if (foundAccount == null) {
            System.out.println("warn: can not find specified account");
            return false;
        } else {
            accountManager.deleteAccount(foundAccount);
            return true;
        }
    }


    private boolean printAccountDetails() {
        String accountNumber = accountHelper.askAccountUniqueId();
        Account foundAccount = accountManager.searchAccount(accountNumber);
        if (foundAccount == null) {
            return false;
        } else {
            System.out.println("Account details...");
            System.out.println("name: " + foundAccount.getName());
            System.out.println("surname: " + foundAccount.getSurname());
            System.out.println("accountNumber: " + foundAccount.getAccountNumber());
            System.out.println("balance: " + foundAccount.getBalance());
            return true;
        }
    }
}
