package com.bh.transactions.data;

import com.bh.transactions.data.TransactionsStorage;
import com.bh.transactions.dto.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TransactionsStorageTest {
    @Test
    public void testAddGet() {
        String transaction11Id = TransactionsStorage.addTransaction("Account1", 150);
        String transaction21Id = TransactionsStorage.addTransaction("Account2", 70);
        String transaction12Id = TransactionsStorage.addTransaction("Account1", 80);

        Optional<List<Transaction>> result = TransactionsStorage.getTransactions("Account1");

        assertEquals(2, result.get().size());
        assertEquals(transaction11Id, result.get().get(0).getId());
        assertEquals(150, result.get().get(0).getAmount());
        assertEquals(transaction12Id, result.get().get(1).getId());
        assertEquals(80, result.get().get(1).getAmount());

        assertEquals(Optional.empty(), TransactionsStorage.getTransactions("XXX"));
    }
}
