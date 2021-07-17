package com.springbootproject.account.Service;

import com.springbootproject.account.Model.Account;
import com.springbootproject.account.Model.Transaction;
import com.springbootproject.account.Model.TransactionType;
import com.springbootproject.account.Repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {


    private Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(Account account, BigDecimal amount) {

        Transaction transaction = new Transaction(TransactionType.INITIAL,amount, LocalDateTime.now(),account);

        return transactionRepository.save(transaction);

    }
}
