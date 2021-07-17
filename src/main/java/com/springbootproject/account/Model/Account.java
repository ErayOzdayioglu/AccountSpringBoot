package com.springbootproject.account.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy =  "org.hibernate.id.UUIDGenerator")
    private String id = "";
    private BigDecimal balance;
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Transaction> transaction;

    public Account(String id, BigDecimal balance, LocalDateTime creationDate, Customer customer, Set<Transaction> transaction) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
        this.transaction = transaction;
    }

    public Account( BigDecimal balance, LocalDateTime creationDate, Customer customer) {
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }
}
