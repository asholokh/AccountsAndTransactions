package com.bh.dataviewer.client;

public class TransactionsClientException extends Exception {
    public TransactionsClientException(String message) {
        super(message);
    }

    public TransactionsClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
