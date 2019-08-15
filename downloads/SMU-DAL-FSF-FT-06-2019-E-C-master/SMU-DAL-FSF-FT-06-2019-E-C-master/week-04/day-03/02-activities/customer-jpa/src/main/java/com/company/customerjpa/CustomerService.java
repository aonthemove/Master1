package com.company.customerjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    public Customer addCustomer(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }

    public void updateCustomer(Customer customer, int id) {
        if(customer.getId() == id) {
            customerRepo.save(customer);
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepo.getOne(id);
    }

    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}
