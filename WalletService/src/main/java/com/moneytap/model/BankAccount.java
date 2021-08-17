package com.moneytap.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {
    @Id
    private String accNo;
    private String ifsc;
    private String bankName;
    private int balance;
    private String walletId;

    public BankAccount() {
    }

    public BankAccount(String accNo, String ifsc, String bankName, int balance, String walletId) {
        this.accNo = accNo;
        this.ifsc = ifsc;
        this.bankName = bankName;
        this.balance = balance;
        this.walletId = walletId;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accNo='" + accNo + '\'' +
                ", ifsc='" + ifsc + '\'' +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                ", walletId='" + walletId + '\'' +
                '}';
    }
}
