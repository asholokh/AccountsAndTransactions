package com.bh.dataviewer.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;

    private int balance;

    private List<Account> accounts = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
