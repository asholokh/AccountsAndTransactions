package com.bh.transactions.service;

import com.bh.transactions.data.TransactionsStorage;
import com.bh.transactions.data.TransactionsStorageImpl;
import com.bh.transactions.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService {
    @Autowired
    private TransactionsStorage transactionsStorage;

    @Override
    public String addTransaction(String accountId, int amount) {
        return transactionsStorage.addTransaction(accountId, amount);
    }

    @Override
    public List<Transaction> getTransactions(String accountId, int limit) {
        Optional<List<Transaction>> transactions = transactionsStorage.getTransactions(accountId);
        if (!transactions.isPresent()) {
            return new ArrayList<>();
        }

        List<Transaction> transactionsList = transactions.get();

        if (limit <= 0) {
            return transactionsList;
        }

        return transactionsList.subList(Math.max(transactionsList.size() - limit, 0), transactionsList.size());
    }
}