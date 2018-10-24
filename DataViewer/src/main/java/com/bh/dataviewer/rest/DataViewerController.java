package com.bh.dataviewer.rest;

import com.bh.dataviewer.client.AccountsClientException;
import com.bh.dataviewer.client.TransactionsClientException;
import com.bh.dataviewer.dto.Customer;
import com.bh.dataviewer.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data/")
public class DataViewerController {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getDataForCustomerId(@PathVariable String customerId) throws AccountsClientException, TransactionsClientException {
        return dataService.getDataForCustomer(customerId);
    }
}
