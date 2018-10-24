package com.bh.accounts.rest;

import com.bh.accounts.dto.Account;
import com.bh.accounts.service.AccountService;
import com.bh.accounts.service.AccountsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts/")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "{customerId}/{name}/{initialCredit}", method = RequestMethod.POST)
    public String createAccount(@PathVariable String customerId, @PathVariable String name, @PathVariable Integer initialCredit) throws AccountsException {
        return accountService.addAccount(customerId, name, initialCredit == null ? 0 : initialCredit);
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public List<Account> getAccounts(@PathVariable String customerId) {
        return accountService.getAccounts(customerId);
    }
}
