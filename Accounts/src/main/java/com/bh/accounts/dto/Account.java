package com.bh.accounts.dto;

import java.util.UUID;

public class Account {
    private String id;

    private String customerId;

    private String name;

    public Account(String customerId, String name) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!id.equals(account.id)) return false;
        if (!customerId.equals(account.customerId)) return false;
        return name.equals(account.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + customerId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
