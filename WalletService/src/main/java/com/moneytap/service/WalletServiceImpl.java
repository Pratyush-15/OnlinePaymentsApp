package com.moneytap.service;

import com.moneytap.exceptions.DuplicateWalletException;
import com.moneytap.exceptions.WalletNotFoundException;
import com.moneytap.model.Wallet;
import com.moneytap.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet getWalletById(String walletId) throws WalletNotFoundException {
        try {
            return walletRepository.findById(walletId).get();
        } catch (NoSuchElementException e){
            throw new WalletNotFoundException("Invalid Wallet Id");
        }
    }

    @Override
    public void createWallet(Wallet wallet) throws DuplicateWalletException {
        try {
            if(getWalletById(wallet.getWalletId())!=null){
                throw new DuplicateWalletException("Wallet already exists");
            }
        } catch (WalletNotFoundException e) {

        }
        walletRepository.save(wallet);
    }

    @Override
    public int getBalance(String walletId) {
        return walletRepository.findById(walletId).get().getBalance();
    }

    @Override
    public boolean addMoney(String walletId, int amount) {
        Wallet wallet = walletRepository.findById(walletId).get();
        wallet.setBalance(wallet.getBalance()+amount);
        walletRepository.save(wallet);
        return true;
    }

    @Override
    public boolean fundTransfer(String walletId1, String walletId2, int amount) {
        Wallet wallet1 = walletRepository.findById(walletId1).get();
        Wallet wallet2 = walletRepository.findById(walletId2).get();
        wallet1.setBalance(wallet1.getBalance()-amount);
        wallet2.setBalance(wallet2.getBalance()+amount);
        walletRepository.save(wallet1);
        walletRepository.save(wallet2);
        return true;
    }

    @Override
    public boolean depositAmount(String walletId, int amount) throws WalletNotFoundException {
        Wallet wallet;
        try {
            wallet = walletRepository.findById(walletId).get();
        } catch (NoSuchElementException e){
            throw new WalletNotFoundException("Invalid Walled Id");
        }
        wallet.setBalance(wallet.getBalance()-amount);
        walletRepository.save(wallet);
        return true;
    }

    @Override
    public void payMoney(String walletId, int amount) {
        Wallet wallet = walletRepository.findById(walletId).get();
        wallet.setBalance(wallet.getBalance()-amount);
        walletRepository.save(wallet);
    }
}
