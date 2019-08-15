package com.company.gamestore.controllers;

import com.company.gamestore.dto.Invoice;
import com.company.gamestore.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {
    @Autowired
    private InvoiceService service;

    @RequestMapping(value="/purchase", method= RequestMethod.POST)
    public Invoice purchase(@RequestBody Invoice invoice) {
        return service.purchaseItem(invoice);
    }
}
