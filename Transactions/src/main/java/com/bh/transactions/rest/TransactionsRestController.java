package com.bh.transactions.rest;

import com.bh.transactions.dto.Transaction;
import com.bh.transactions.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transactions/", method = RequestMethod.GET)
public class TransactionsRestController {
    @Autowired
    private TransactionsService transactionsService;


    @RequestMapping(value = "{accountId}/{amount}", method = RequestMethod.POST)
    public String addTransaction(@PathVariable String accountId, @PathVariable Integer amount) {
        return transactionsService.addTransaction(accountId, amount);
    }

    @RequestMapping(value = "{accountId}/{limit}", method = RequestMethod.GET)
    public List<Transaction> getTansactions(@PathVariable String accountId, @PathVariable Integer limit) {
        return transactionsService.getTransactions(accountId, limit == null ? -1 : limit);
    }
}
