package com.sejo.sales_management_system.accounts;

import com.sejo.sales_management_system.Sha256Hashing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner accountCommandLineRunner(AccountRepository accountRepository){
        return args -> {
            Account admin = new Account(
                    "admin@seysales.com",
                    "admin",
                    Sha256Hashing.Hash("admin"),
                    1L
            );
            Account sejo = new Account(
                    "sejo@seysales.com",
                    "sejo",
                    Sha256Hashing.Hash("sejo"),
                    2L
            );
            accountRepository.save(admin);
            accountRepository.save(sejo);
        };
    }
}
