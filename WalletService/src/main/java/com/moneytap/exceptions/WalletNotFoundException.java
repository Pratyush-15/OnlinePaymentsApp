package com.moneytap.exceptions;

public class WalletNotFoundException extends Exception{
    public WalletNotFoundException(String message) {
        super(message);
    }
}
