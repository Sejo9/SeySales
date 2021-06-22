package com.sejo.sales_management_system.orders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalesConfig {

    @Bean
    CommandLineRunner orderCommandLineRunner(SalesRepository salesRepository){
        return args -> {
            Sales one = new Sales(
                    "Eliana Jensen",
                    "PlayStation 4",
                    2,
                    1200,
                    "Jose Moses",
                    "No"
            );

            Sales two = new Sales(
                    "John Doe",
                    "Nintendo Switch",
                    1,
                    500,
                    "Steven Mensah",
                    "No"
            );

            Sales three = new Sales(
                    "Seraphina Welsh",
                    "XBox One",
                    1,
                    550,
                    "Jessica Stevens",
                    "No"
            );

            salesRepository.save(one);
            salesRepository.save(two);
            salesRepository.save(three);
        };
    }
}
