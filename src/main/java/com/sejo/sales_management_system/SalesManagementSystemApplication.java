package com.sejo.sales_management_system;

import com.sejo.sales_management_system.staff.Staff;
import com.sejo.sales_management_system.staff.StaffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SalesManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesManagementSystemApplication.class, args);
    }



}
