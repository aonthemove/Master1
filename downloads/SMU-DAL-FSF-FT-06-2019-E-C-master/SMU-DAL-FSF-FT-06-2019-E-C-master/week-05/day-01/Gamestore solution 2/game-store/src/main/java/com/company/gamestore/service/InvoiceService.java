package com.company.gamestore.service;

import com.company.gamestore.dao.*;
import com.company.gamestore.dto.*;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.security.InvalidParameterException;

@Component
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepo;
    @Autowired
    private SalesTaxRateRepository taxRepo;
    @Autowired
    private ProcessingFeeRepository processingFeeRepo;
    @Autowired
    private ConsoleRepository consoleRepo;
    @Autowired
    private GameRepository gameRepo;
    @Autowired
    private TShirtRepository tshirtRepo;

    public Invoice purchaseItem(Invoice invoice) {
        String itemType = invoice.getItemType();
        int quantity = invoice.getQuantity(),
                itemId = invoice.getItemId();

        if (!this.typeValid(itemType)) {
            throw new InvalidParameterException("Item type must be one of the following: game, console, or tshirt");
        }
        if (quantity <= 0) {
            throw new InvalidParameterException("Item quantity must be greater than 0");
        }

        if (!this.itemsAvailable(itemType, itemId, quantity)) {
            throw new InvalidParameterException("Sorry, we don't have that many items available.");
        }

        Double itemPrice = this.getItemPrice(itemType, itemId),
                taxRate = this.getTaxByState(invoice.getState()),
                processingFee = this.getProcessingFeeByType(itemType),
                subtotal = itemPrice * quantity,
                tax = taxRate * subtotal,
                total = subtotal + tax;

        if (quantity > 10) {
            processingFee += 15.49;
        }

        total += processingFee;

        invoice.setUnitPrice(itemPrice);
        invoice.setSubtotal(subtotal);
        invoice.setTax(tax);
        invoice.setProcessingFee(processingFee);
        invoice.setTotal(total);

        this.updateItemQuantity(itemType, itemId, quantity);

        invoiceRepo.save(invoice);
        return invoice;
    }

    private Double getTaxByState(String state) {
        SalesTaxRate tax = taxRepo.findByState(state);
         if (tax == null) {
             throw new InvalidParameterException("Invalid state " + state);
         }
        return tax.getRate();
    }

    private Double getProcessingFeeByType(String type) {
        ProcessingFee processingFee = processingFeeRepo.findByProductType(type);
        return processingFee.getFee();
    }

    private Double getItemPrice(String type, int id) {
        Double price = 0.0;

        switch(type.toLowerCase()) {
            case "game":
                Game game = gameRepo.getOne(id);
                price = game.getPrice();
                break;
            case "console":
                Console console = consoleRepo.getOne(id);
                price = console.getPrice();
                break;
            case "tshirt":
                TShirt tshirt = tshirtRepo.getOne(id);
                price = tshirt.getPrice();
        }

        return price;
    }

    private void updateItemQuantity(String type, int id, int quantity) {
        switch(type.toLowerCase()) {
            case "game":
                Game game = gameRepo.getOne(id);
                game.setQuantity(game.getQuantity() - quantity);
                break;
            case "console":
                Console console = consoleRepo.getOne(id);
                console.setQuantity(console.getQuantity() - quantity);
                break;
            case "tshirt":
                TShirt tshirt = tshirtRepo.getOne(id);
                tshirt.setQuantity(tshirt.getQuantity() - quantity);
        }
    }

    private boolean itemsAvailable(String type, int id, int quantity) {
        boolean available = false;

        switch(type.toLowerCase()) {
            case "game":
                Game game = gameRepo.getOne(id);
                if (game.getQuantity() >= quantity) {
                    available = true;
                }
                break;
            case "console":
                Console console = consoleRepo.getOne(id);
                if (console.getQuantity() >= quantity) {
                    available = true;
                }
                break;
            case "tshirt":
                TShirt tshirt = tshirtRepo.getOne(id);
                if (tshirt.getQuantity() >= quantity) {
                    available = true;
                }
        }

        return available;
    }

    private boolean typeValid(String type) {
        type = type.toLowerCase();
        if (type.equals("game") || type.equals("console") || type.equals("tshirt")) {
            return true;
        }

        return false;
    }
}
