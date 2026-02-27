package com.example.payment_demo.repository;

import com.example.payment_demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByAccountNumber(String accountNumber);

    boolean existsByEmail(String email);

    Optional<Account> findByAccountNumber(String accountNumber);
}
