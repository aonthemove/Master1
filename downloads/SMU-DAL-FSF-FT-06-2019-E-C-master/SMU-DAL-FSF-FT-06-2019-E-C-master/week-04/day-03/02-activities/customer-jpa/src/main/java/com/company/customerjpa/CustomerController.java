package com.company.customerjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @RequestMapping(value="/customers", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
        return customer;
    }

    @RequestMapping(value="/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    @RequestMapping(value="/customers/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
        service.updateCustomer(customer, id);
    }

    @RequestMapping(value="/customers/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int id) {
        service.deleteCustomer(id);
    }
}
