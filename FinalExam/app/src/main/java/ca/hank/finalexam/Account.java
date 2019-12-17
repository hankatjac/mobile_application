package ca.hank.finalexam;

import java.io.Serializable;

public class Account implements Serializable {
    private  String accountNumber;
    private  String openDate;
    private float balance;

    public Account(String accountNumber, String openDate, float balance) {
        this.accountNumber = accountNumber;
        this.openDate = openDate;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
