package com.banking.transaction;

import com.banking.account.manager.Account;

public interface Transaction {
    String getName();

    Account getTargetAccount();

    Account getToAccount();

    String getTransactionDescription();
}
