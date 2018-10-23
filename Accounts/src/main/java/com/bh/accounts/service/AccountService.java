package com.bh.accounts.service;

import com.bh.accounts.dto.Account;

import java.util.List;

public interface AccountService {
    /**
     * Adds new account for given <code>customerId</code> with given <code>name</code> and <code>initialCredit</code>.
     *
     * @param customerId    Customer id.
     * @param name          Account user name.
     * @param initialCredit Initial credit. Can be both positive and negative.
     * @return Created account id.
     */
    String addAccount(String customerId, String name, int initialCredit);

    /**
     * Gets accounts for given <code>customerId</code>.
     *
     * @param customerId Customer id
     * @return List of accounts. Empty list if there are no accounts for given <code>customerId</code>.
     */
    List<Account> getAccounts(String customerId);
}
