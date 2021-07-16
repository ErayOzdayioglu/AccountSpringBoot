package com.springbootproject.account.DTO;

import com.springbootproject.account.Model.Transaction;

public class TransactionDtoConverter {

    public TransactionDto convert(Transaction transaction) {
        return new TransactionDto(transaction.getId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionTime());
    }
}
