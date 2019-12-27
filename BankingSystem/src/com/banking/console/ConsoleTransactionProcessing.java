package com.banking.console;

import com.banking.account.helpers.AccountHelper;
import com.banking.account.helpers.TransactionHelper;
import com.banking.account.manager.Account;
import com.banking.account.manager.AccountManager;
import com.banking.transaction.Transaction;
import com.banking.transaction.TransactionManager;

import java.util.Scanner;

public class ConsoleTransactionProcessing {
    private AccountManager accountManager;
    private TransactionManager transactionManager;
    private TransactionHelper transactionHelper;
    private AccountHelper accountHelper;

    public ConsoleTransactionProcessing(AccountManager accountManager, TransactionManager transactionManager) {
        this.accountManager = accountManager;
        this.transactionManager = transactionManager;
        this.transactionHelper = new TransactionHelper();
        this.accountHelper = new AccountHelper();
    }


    public boolean processTransactionRelatedActions() {
        System.out.println("******** Choose Action ********");
        System.out.println("1: deposit");
        System.out.println("2: withdraw");
        System.out.println("3: transfer");
        System.out.println("4: see all transactions");

        Scanner sc = new Scanner(System.in);
        int chosenOperation = sc.nextInt();

        if (chosenOperation != 1 && chosenOperation != 2 && chosenOperation != 3) {
            System.out.println("invalid operation, please chose correct one...");
            return processTransactionRelatedActions();
        } else {

            switch (chosenOperation) {
                case 1:
                    return makeDeposit();

                case 2:
                    return makeWithdraw();

                case 3:
                    return makeTransfer();

                case 4:
                    return printAllTransactions();

                default:
                    return false;
            }
        }
    }


    private boolean makeDeposit() {
        String accountNumber = accountHelper.askAccountUniqueId();
        Account foundAccount = accountManager.searchAccount(accountNumber);

        if (foundAccount == null) {
            System.out.println("invalid account number, try again...");
            return makeDeposit();
        } else {
            double amount = transactionHelper.askAmount("deposit");
            transactionManager.deposit(foundAccount, amount);
        }
        return true;
    }


    private boolean makeWithdraw() {
        String accountNumber = accountHelper.askAccountUniqueId();
        Account foundAccount = accountManager.searchAccount(accountNumber);

        if (foundAccount == null) {
            System.out.println("invalid account number, try again...");
            return makeWithdraw();
        } else {
            double amount = transactionHelper.askAmount("withdraw");
            transactionManager.withdraw(foundAccount, amount);
        }

        return true;
    }


    private boolean makeTransfer() {
        String fromAccountNumber = accountHelper.askAccountUniqueId();
        Account fromAccount = accountManager.searchAccount(fromAccountNumber);
        System.out.println("enter account to transfer to");

        String toAccountNumber = accountHelper.askAccountUniqueId();
        Account toAccount = accountManager.searchAccount(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("invalid accounts, try again...");
            return makeTransfer();
        } else {
            double amount = transactionHelper.askAmount("transfer");
            transactionManager.transfer(fromAccount, toAccount, amount);
        }

        return true;
    }


    private boolean printAllTransactions() {
        Transaction[] allTransactions = transactionManager.getAllTransactions();
        if (allTransactions != null && allTransactions.length > 0) {
            for (int i = 0; i < allTransactions.length; i++) {
                printSingleTransaction(allTransactions[i]);
            }

            return true;
        } else {
            System.out.println("no transaction exists yet!");
            return false;
        }
    }

    private void printSingleTransaction(Transaction transaction) {
        System.out.println("*******************************************************************************");
        System.out.println("transaction type: " + transaction.getName());
        System.out.println("account: " + transaction.getTargetAccount());

        if (transaction.getName().equalsIgnoreCase("transfer")) {
            System.out.println("to account: " + transaction.getToAccount());
        }

        System.out.println("description: " + transaction.getTransactionDescription());
        System.out.println("*******************************************************************************");
    }
}
