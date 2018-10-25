package com.bh.transactions.data;

import com.bh.transactions.dto.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Scope("singleton")
public final class TransactionsStorageImpl implements TransactionsStorage {
    private final Map<String, List<Transaction>> data = new HashMap<>();

    @Override
    public synchronized String addTransaction(String accountId, int amount) {
        Transaction transaction = new Transaction(accountId, amount);
        if (!data.containsKey(accountId)) {
            data.put(accountId, new ArrayList<>());
            data.get(accountId).add(transaction);
        } else {
            data.get(accountId).add(transaction);
        }

        return transaction.getId();
    }

    @Override
    public synchronized Optional<List<Transaction>> getTransactions(String accountId) {
        if (!data.containsKey(accountId)) {
            return Optional.empty();
        }

        return Optional.of(new ArrayList<>(data.get(accountId)));
    }
}
