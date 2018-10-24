package com.bh.accounts.service;

import com.bh.accounts.client.TransactionsClientException;

public class AccountsException extends Exception {
    public AccountsException(String s, TransactionsClientException e) {
        super(s, e);
    }
}
