package com.bh.accounts.data;

import com.bh.accounts.dto.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class AccountsStorage {
    private static final Map<String, List<Account>> data = new HashMap<>();

    public static synchronized String addAccount(String customerId, String name) {
        Account account = new Account(customerId, name);
        if (!data.containsKey(customerId)) {
            data.put(customerId, new ArrayList<>());
            data.get(customerId).add(account);
        } else {
            data.get(customerId).add(account);
        }

        return account.getId();
    }

    public static synchronized Optional<List<Account>> getAccounts(String customerId) {
        if (!data.containsKey(customerId)) {
            return Optional.empty();
        }

        return Optional.of(new ArrayList<>(data.get(customerId)));
    }
}
