package com.springbootproject.account.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy =  "org.hibernate.id.UUIDGenerator")
    private String id;

    private TransactionType transactionType = TransactionType.INITIAL;

    private BigDecimal amount;

    private LocalDateTime transactionTime;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name= "account_id",nullable = false)
    private Account account;

    public Transaction(String id, TransactionType transactionType, BigDecimal amount, LocalDateTime transactionTime, Account account) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.account = account;
    }

    public Transaction (TransactionType transactionType, BigDecimal amount, LocalDateTime transactionTime, Account account) {

        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.account = account;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
