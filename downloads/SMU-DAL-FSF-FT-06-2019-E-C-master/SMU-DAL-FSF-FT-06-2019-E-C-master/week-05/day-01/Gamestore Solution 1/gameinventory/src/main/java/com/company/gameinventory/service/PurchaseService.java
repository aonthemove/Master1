package com.company.gameinventory.service;

import com.company.gameinventory.dao.*;
import com.company.gameinventory.dto.Console;
import com.company.gameinventory.dto.Game;
import com.company.gameinventory.dto.Invoice;
import com.company.gameinventory.dto.TShirt;
import com.company.gameinventory.viewModel.Purchase;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PurchaseService {

    @Autowired
    private ConsoleRepository consoleRepo;
    @Autowired
    private GameRepository gameRepo;
    @Autowired
    private TShirtRepository shirtRepo;
    @Autowired
    private ProcessingFeeRepository feeRepo;
    @Autowired
    private SalesTaxRateRepository taxRepo;
    @Autowired
    private InvoiceRepository invoiceRepo;


    public Invoice generateInvoice(Purchase purchase) {
        Invoice invoice = new Invoice();
        invoice.setName(purchase.getName());
        invoice.setStreet(purchase.getStreet());
        invoice.setCity(purchase.getCity());
        invoice.setState(purchase.getState());
        invoice.setZipcode(purchase.getZipcode());
        invoice.setItemType(purchase.getItemType());
        invoice.setItemId(purchase.getItemId());
        invoice.setQuantity(purchase.getQuantity());

        switch (invoice.getItemType().toLowerCase()) {
            case "game":
                invoice = addGameDetails(invoice);
                break;
            case "console":
                invoice = addConsoleDetails(invoice);
                break;
            case "tshirt":
            case "t shirt":
            case "t-shirt":
                invoice = addTShirtDetails(invoice);
        }

        invoice = addTaxAndFees(invoice);

        return invoice;
    }

    private Invoice addTaxAndFees(Invoice invoice) {

        invoice.setSubTotal( invoice.getUnitPrice().multiply(new BigDecimal(invoice.getQuantity())) );
        invoice.setTax( invoice.getSubTotal().multiply(taxRepo.getOne(invoice.getState()).getRate()) );

        if ( invoice.getQuantity() > 10 ) {
            invoice.setProcessingFee( new BigDecimal("15.49").add( feeRepo.getOne(invoice.getItemType()).getFee() ));
        } else {
            invoice.setProcessingFee( feeRepo.getOne(invoice.getItemType()).getFee() );
        }

        invoice.setTotal( invoice.getSubTotal().add(invoice.getProcessingFee()).add(invoice.getTax()) );

        return invoice;
    }

    private Invoice addGameDetails(Invoice invoice) {
        Game game = gameRepo.getOne(invoice.getItemId());

        if (game.getQuantity() < invoice.getQuantity()) {
            throw new RuntimeException("Insufficient Quantity");
        }

        game.setQuantity( game.getQuantity() - invoice.getQuantity());
        gameRepo.save(game);

        invoice.setUnitPrice(game.getPrice());

        return invoice;
    }

    private Invoice addConsoleDetails(Invoice invoice) {

        Console console = consoleRepo.getOne(invoice.getItemId());

        if (console.getQuantity() < invoice.getQuantity()) {
            throw new RuntimeException("Insufficient Quantity");
        }

        console.setQuantity( console.getQuantity() - invoice.getQuantity());
        consoleRepo.save(console);

        invoice.setUnitPrice(console.getPrice());

        return invoice;
    }

    private Invoice addTShirtDetails(Invoice invoice) {

        TShirt shirt = shirtRepo.getOne(invoice.getItemId());

        if (shirt.getQuantity() < invoice.getQuantity()) {
            throw new RuntimeException("Insufficient Quantity");
        }

        shirt.setQuantity( shirt.getQuantity() - invoice.getQuantity());
        shirtRepo.save(shirt);

        invoice.setUnitPrice(shirt.getPrice());

        return invoice;
    }
}
