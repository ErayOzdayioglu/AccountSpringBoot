package com.springbootproject.account.Repository;

import com.springbootproject.account.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
