package com.anz.wholesale.account.repository;

import com.anz.wholesale.account.domain.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t INNER JOIN t.account a where a.accountNumber = ?1")

    List<Transaction> findByAccountNumber(String accountNumber, Pageable page);
}
