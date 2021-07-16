package com.springbootproject.account.Repository;

import com.springbootproject.account.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
