package com.moneytap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class BillPayment {
    @Id
    private String billId;
    private String billType;
    private int amount;
    private Date paymentDate;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public BillPayment() {
    }

    public BillPayment(String billId, String billType, int amount, Date paymentDate, Wallet wallet) {
        this.billId = billId;
        this.billType = billType;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.wallet = wallet;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "BillPayment{" +
                "billId='" + billId + '\'' +
                ", billType='" + billType + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", walletId='" + wallet + '\'' +
                '}';
    }
}
