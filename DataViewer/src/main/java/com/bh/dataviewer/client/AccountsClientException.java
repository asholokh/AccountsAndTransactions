package com.bh.dataviewer.client;

public class AccountsClientException extends Exception {
    public AccountsClientException(String message) {
        super(message);
    }

    public AccountsClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
