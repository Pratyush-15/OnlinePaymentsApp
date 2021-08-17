package com.moneytap.service;

import com.moneytap.exceptions.DuplicateWalletException;
import com.moneytap.exceptions.WalletNotFoundException;
import com.moneytap.model.Wallet;

public interface WalletService {
    Wallet getWalletById(String walletId) throws WalletNotFoundException;
    void createWallet(Wallet wallet) throws DuplicateWalletException;
    int getBalance(String walletId);
    boolean addMoney(String walletId, int amount);
    boolean fundTransfer(String walletId1, String walletId2, int amount);
    boolean depositAmount(String walletId, int amount) throws WalletNotFoundException;
    void payMoney(String walletId, int amount);
}
