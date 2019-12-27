package com.banking.account.manager;

import java.util.Objects;
import java.util.Random;

public class BankAccount implements Account {
    private String name;
    private String surname;
    private double balance;
    private String accountNumber;

    public BankAccount(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.balance = 0;
        this.accountNumber = "HSBC_" + new Random(999999).nextInt();
    }

    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount myAccount = (BankAccount) o;
        return Double.compare(myAccount.balance, balance) == 0 &&
                Objects.equals(name, myAccount.name) &&
                Objects.equals(surname, myAccount.surname) &&
                Objects.equals(accountNumber, myAccount.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, balance, accountNumber);
    }

    @Override
    public String toString() {
        return "MyAccount{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
