package com.springbootproject.account.DTO;

import com.springbootproject.account.Model.Account;

import java.util.stream.Collectors;

public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account account) {
        return new AccountDto(account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                customerDtoConverter.convertToAccountCustomer(account.getCustomer()),
                        account.getTransaction().stream().map(t -> transactionDtoConverter.convert(t)).collect(Collectors.toSet()));

    }
}
