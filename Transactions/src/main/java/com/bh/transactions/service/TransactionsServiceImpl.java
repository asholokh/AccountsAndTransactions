package com.bh.transactions.service;

import com.bh.transactions.data.TransactionsStorage;
import com.bh.transactions.dto.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService {
    @Override
    public String addTransaction(String accountId, int amount) {
        return TransactionsStorage.addTransaction(accountId, amount);
    }

    @Override
    public List<Transaction> getTransactions(String accountId, int limit) {
        Optional<List<Transaction>> transactions = TransactionsStorage.getTransactions(accountId);
        if (!transactions.isPresent()) {
            return new ArrayList<>();
        }

        List<Transaction> transactionsList = transactions.get();

        if (limit < 0) {
            return transactionsList;
        }

        return transactionsList.subList(Math.max(transactionsList.size() - limit, 0), transactionsList.size());
    }
}