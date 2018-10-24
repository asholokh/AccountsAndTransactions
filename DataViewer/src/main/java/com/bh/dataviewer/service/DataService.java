package com.bh.dataviewer.service;

import com.bh.dataviewer.client.AccountsClient;
import com.bh.dataviewer.client.AccountsClientException;
import com.bh.dataviewer.client.TransactionsClient;
import com.bh.dataviewer.client.TransactionsClientException;
import com.bh.dataviewer.dto.Account;
import com.bh.dataviewer.dto.Customer;
import com.bh.dataviewer.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @Value("${transactions.limit}")
    private int transactionsLimit;

    @Autowired
    private AccountsClient accountsClient;

    @Autowired
    private TransactionsClient transactionsClient;

    public Customer getDataForCustomer(String customerId) throws AccountsClientException, TransactionsClientException {
        Customer customer = new Customer();
        customer.setId(customerId);

        List<Account> accounts = accountsClient.getAccountsForCustomerId(customerId);
        for (Account account : accounts) {
            List<Transaction> transactions = transactionsClient.getTransactionsForAccountId(account.getId(), transactionsLimit);
            account.getTransactions().addAll(transactions);
            List<Transaction> allTransactions = transactionsClient.getAllTransactionsForAccountId(account.getId());
            account.setBalance(calcTotalBalanceForAccount(allTransactions));
        }

        customer.getAccounts().addAll(accounts);
        customer.setBalance(calcTotalBalanceForCustomer(accounts));

        return customer;
    }

    private int calcTotalBalanceForCustomer(List<Account> accounts) {
        return accounts.stream().mapToInt(Account::getBalance).reduce(Integer::sum).orElse(0);
    }

    private int calcTotalBalanceForAccount(List<Transaction> transactions) {
        return transactions.stream().mapToInt(Transaction::getAmount).reduce(Integer::sum).orElse(0);
    }

}
