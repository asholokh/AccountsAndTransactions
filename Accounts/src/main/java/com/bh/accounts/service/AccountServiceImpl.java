package com.bh.accounts.service;

import com.bh.accounts.client.TransactionsClient;
import com.bh.accounts.client.TransactionsClientException;
import com.bh.accounts.data.AccountsStorage;
import com.bh.accounts.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private TransactionsClient transactionsClient;

    @Override
    public String addAccount(String customerId, String name, int initialCredit) throws AccountsException {
        String accountId = AccountsStorage.addAccount(customerId, name);

        try {
            if (initialCredit > 0) {
                transactionsClient.createTransaction(accountId, initialCredit);
            }
        } catch (TransactionsClientException e) {
            AccountsStorage.deleteAccount(customerId, accountId);
            throw new AccountsException("Account could not be added for customerId: " + customerId, e);
        }

        return accountId;
    }

    @Override
    public List<Account> getAccounts(String customerId) {
        return AccountsStorage.getAccounts(customerId).orElseGet(ArrayList::new);
    }
}