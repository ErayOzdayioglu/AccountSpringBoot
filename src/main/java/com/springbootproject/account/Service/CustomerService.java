package com.springbootproject.account.Service;


import com.springbootproject.account.Exceptions.CustomerNotFoundException;
import com.springbootproject.account.Model.Customer;
import com.springbootproject.account.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer could not found"));
    }
}
