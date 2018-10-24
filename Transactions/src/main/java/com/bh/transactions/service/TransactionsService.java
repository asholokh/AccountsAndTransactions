package com.bh.transactions.service;

import com.bh.transactions.dto.Transaction;

import java.util.List;

public interface TransactionsService {
    /**
     * Adds new transaction for given <code>accountId</code> with given <code>amount</code>.
     *
     * @param accountId Account id.
     * @param amount    Amount. Can be both positive and negative.
     * @return Created transaction id.
     */
    String addTransaction(String accountId, int amount);

    /**
     * Gets last <code>limit</code> transactions for given <code>accountId</code>.
     * If <code>limit</code> is less than 1, all transactions for for given <code>accountId</code> will be returned.
     *
     * @param accountId Account id
     * @param limit     Amount of last transaction to be returned.
     * @return List of transactions. Empty list if there are no transactions for given <code>accountId</code>.
     */
    List<Transaction> getTransactions(String accountId, int limit);
}
