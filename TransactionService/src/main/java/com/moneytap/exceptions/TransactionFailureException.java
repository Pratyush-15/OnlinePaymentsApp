package com.moneytap.exceptions;

public class TransactionFailureException extends Exception{
    public TransactionFailureException(String message) {
        super(message);
    }
}
