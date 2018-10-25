package com.bh.transactions.data;

import com.bh.transactions.dto.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionsStorage {
    /**
     * Adds transaction for given account
     *
     * @param accountId Account ID
     * @param amount    Transaction amount
     * @return ID of created transaction
     */
    String addTransaction(String accountId, int amount);

    /**
     * Gets transasctions for given account
     *
     * @param accountId Account ID
     * @return Optional <code>List</code> of <code>Transaction</code> instances
     */
    Optional<List<Transaction>> getTransactions(String accountId);
}
