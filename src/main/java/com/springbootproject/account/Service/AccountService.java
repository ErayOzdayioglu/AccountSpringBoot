package com.springbootproject.account.Service;

import com.springbootproject.account.DTO.AccountDto;
import com.springbootproject.account.DTO.AccountDtoConverter;
import com.springbootproject.account.DTO.CreateAccountRequest;
import com.springbootproject.account.Model.Account;
import com.springbootproject.account.Model.Customer;
import com.springbootproject.account.Model.Transaction;
import com.springbootproject.account.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, TransactionService transactionService, AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(createAccountRequest.getInitialCredit(), LocalDateTime.now(),customer);

        Transaction transaction = transactionService.initiateMoney(account,createAccountRequest.getInitialCredit());
        account.getTransaction().add(transaction);

        return accountDtoConverter.convert(accountRepository.save(account));

    }


}
