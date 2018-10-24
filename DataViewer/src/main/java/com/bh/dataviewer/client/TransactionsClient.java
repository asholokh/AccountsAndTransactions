package com.bh.dataviewer.client;

import com.bh.dataviewer.dto.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TransactionsClient {
    @Value("${get.transactions.service.url}")
    private String getTransactionsServiceUrl;

    public List<Transaction> getTransactionsForAccountId(String accountId, int limit) throws TransactionsClientException {
        return getTransactions(accountId, limit);
    }

    public List<Transaction> getAllTransactionsForAccountId(String accountId) throws TransactionsClientException {
        return getTransactions(accountId, -1);
    }


    private List<Transaction> getTransactions(String accountId, int limit) throws TransactionsClientException {
        RestTemplate restTemplate = new RestTemplate();

        String limitStr = limit > 0 ? Integer.toString(limit) : "0";
        String url = String.format(getTransactionsServiceUrl, accountId, limitStr);
        try {
            return Arrays.asList(restTemplate.getForObject(url, Transaction[].class));
        } catch (RestClientException e) {
            throw new TransactionsClientException("Transactions could not be loaded for account id: " + accountId, e);
        }
    }
}
