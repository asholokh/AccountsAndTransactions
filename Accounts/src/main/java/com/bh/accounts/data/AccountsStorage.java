package com.bh.accounts.data;

import com.bh.accounts.dto.Account;

import java.util.List;
import java.util.Optional;

public interface AccountsStorage {
    /**
     * Add new account for given Customer
     *
     * @param customerId Customer ID
     * @param name       Account name
     * @return
     */
    String addAccount(String customerId, String name);

    /**
     * Deletes account
     *
     * @param customerId Customer ID
     * @param accountId  Account ID
     */
    void deleteAccount(String customerId, String accountId);

    /**
     * Gets accounts for given customer
     *
     * @param customerId Customer ID
     * @return Optional <code>List</code> of <code>Account</code> instances.
     */
    Optional<List<Account>> getAccounts(String customerId);
}
