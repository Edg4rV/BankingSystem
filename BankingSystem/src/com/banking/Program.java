package com.banking;

import com.banking.account.manager.AccountManager;
import com.banking.account.manager.BankAccountManager;
import com.banking.console.ConsoleAccountProcessing;
import com.banking.console.ConsoleTransactionProcessing;
import com.banking.transaction.BankTransactionManager;
import com.banking.transaction.TransactionManager;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        AccountManager bankAccountManager = new BankAccountManager();
        TransactionManager bankTransactionManager = new BankTransactionManager();

        process(bankAccountManager, bankTransactionManager);
    }


    private static void process(AccountManager accountManager, TransactionManager transactionManager) {
        System.out.println("******** Choose Action ********");
        System.out.println("1: Account management");
        System.out.println("2: Transaction management");

        Scanner sc = new Scanner(System.in);
        int chosenOperation = sc.nextInt();

        if (chosenOperation == 1) {

            ConsoleAccountProcessing consoleAccountProcessing = new ConsoleAccountProcessing(accountManager);
            boolean processResult = consoleAccountProcessing.processAccountRelatedActions();
            checkProcessResult(processResult, accountManager, transactionManager);

        } else if (chosenOperation == 2) {
            ConsoleTransactionProcessing consoleTransactionProcessing = new ConsoleTransactionProcessing(accountManager, transactionManager);
            boolean processResult = consoleTransactionProcessing.processTransactionRelatedActions();

            checkProcessResult(processResult, accountManager, transactionManager);

        } else {
            System.out.println("invalid chosen operation...");
            process(accountManager, transactionManager);
        }
    }


    private static void checkProcessResult(boolean processResult, AccountManager accountManager, TransactionManager transactionManager) {
        if (processResult) {
            System.out.println("Process succeed...");
        } else {
            System.out.println("Something went wrong during processing, please try again..");
        }

        process(accountManager, transactionManager);
    }
}
