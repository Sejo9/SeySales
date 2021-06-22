package com.sejo.sales_management_system.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner customerCommandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer eliana = new Customer(
                    "Eliana",
                    "Mason",
                    "Female",
                    "eliana@panther.com",
                    "0201447927"
            );

            customerRepository.save(eliana);
        };
    }
}
