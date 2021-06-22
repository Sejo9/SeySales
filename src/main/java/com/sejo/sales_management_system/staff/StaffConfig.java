package com.sejo.sales_management_system.staff;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class StaffConfig {

    @Bean
    CommandLineRunner staffCommandLineRunner(StaffRepository staffRepository){
        return args -> {
            Staff admin = new Staff("Admin","Sejo",
                    LocalDate.now(),
                    1,
                    "Admin");
            Staff sejo = new Staff("Jose","Moses",
                    LocalDate.now(),
                    2,
                    "Salesperson");
            staffRepository.save(admin);
            staffRepository.save(sejo);

        };
    }
}
