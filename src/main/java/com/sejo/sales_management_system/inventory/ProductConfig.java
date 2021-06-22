package com.sejo.sales_management_system.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner productCommandLineRunner(ProductRepository productRepository){
        return args -> {
            Product ps = new Product(
                    "PlayStation 4",
                    0,
                    600,
                    "Warehouse 1",
                    "Low",
                    "A gaming console produced by Sony Entertainment"
            );

            Product nSwitch = new Product(
                    "Nintendo Switch",
                    60,
                    500,
                    "Warehouse 2",
                    "Low",
                    "A gaming console and handheld device combination developed by Nintendo"
            );

            Product xbox = new Product(
                    "XBox One",
                    80,
                    550,
                    "Warehouse 3",
                    "Low",
                    "A gaming console created by Microsoft"
            );

            Product alien = new Product(
                    "Alienware",
                    0,
                    600,
                    "Warehouse 1",
                    "Low",
                    "A powerful computer popularly used in gaming"
            );

            productRepository.save(alien);
            productRepository.save(ps);
            productRepository.save(nSwitch);
            productRepository.save(xbox);
        };
    }
}
