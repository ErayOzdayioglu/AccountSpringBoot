package com.springbootproject.account.DTO;

import com.springbootproject.account.Model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer(Customer customer) {
        if (customer == null) {
            return new AccountCustomerDto("","","");
        }
        return new AccountCustomerDto(customer.getId(),customer.getName(),customer.getSurname());
    }
}
