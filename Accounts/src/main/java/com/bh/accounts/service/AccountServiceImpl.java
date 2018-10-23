package com.bh.accounts.service;

import com.bh.accounts.data.AccountsStorage;
import com.bh.accounts.dto.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public String addAccount(String customerId, String name, int initialCredit) {
        // TODO: Send transaction request

        boolean accountTransactionSuccess = true;

        if (accountTransactionSuccess) {
            return AccountsStorage.addAccount(customerId, name);
        } else {
            throw new IllegalStateException("Transactions service temporary unavailable");
        }
    }

    @Override
    public List<Account> getAccounts(String customerId) {
        return AccountsStorage.getAccounts(customerId).orElseGet(ArrayList::new);
    }
}