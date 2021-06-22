package com.sejo.sales_management_system.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    Optional<Sales> findSalesByCustomerNameAndProductName(String customerName, String productName);
}
