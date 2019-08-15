package com.company.gameinventory.controllers;

import com.company.gameinventory.dto.Invoice;
import com.company.gameinventory.service.PurchaseService;
import com.company.gameinventory.viewModel.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping(value="/purchase")
    public Invoice createInvoice(@RequestBody @Valid Purchase purchase) {
        return purchaseService.generateInvoice(purchase);
    }
}
