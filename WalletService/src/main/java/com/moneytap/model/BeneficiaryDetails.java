package com.moneytap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class BeneficiaryDetails {
    @Id
    private String beneficiaryId;
    private String name;
    private String mobile;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public BeneficiaryDetails() {
    }

    public BeneficiaryDetails(String beneficiaryId, String name, String mobile, Wallet wallet) {
        this.beneficiaryId = beneficiaryId;
        this.name = name;
        this.mobile = mobile;
        this.wallet = wallet;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(String beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Wallet getWallet() {
        return wallet;
    }

    @JsonIgnore
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "BeneficiaryDetails{" +
                "beneficiaryId='" + beneficiaryId + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", walletId='" + wallet.getWalletId() + '\'' +
                '}';
    }
}
