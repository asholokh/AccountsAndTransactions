package com.bh.transactions.data;

import com.bh.transactions.dto.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class TransactionsStorage {
    private static final Map<String, List<Transaction>> data = new HashMap<>();

    public static synchronized String addTransaction(String accountId, int amount) {
        Transaction transaction = new Transaction(accountId, amount);
        if (!data.containsKey(accountId)) {
            data.put(accountId, new ArrayList<>());
            data.get(accountId).add(transaction);
        } else {
            data.get(accountId).add(transaction);
        }

        return transaction.getId();
    }

    public static synchronized Optional<List<Transaction>> getTransactions(String accountId) {
        if (!data.containsKey(accountId)) {
            return Optional.empty();
        }

        return Optional.of(new ArrayList<>(data.get(accountId)));
    }
}
