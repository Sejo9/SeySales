package com.sejo.sales_management_system.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.username = ?1")
    Optional<Account> findAccountByUsername(String username);

    @Query("SELECT a FROM Account a WHERE a.email = ?1")
    Optional<Account> findAccountByEmail(String email);

    Optional<Account> findAccountByEmailAndUsername(String email, String username);
}
