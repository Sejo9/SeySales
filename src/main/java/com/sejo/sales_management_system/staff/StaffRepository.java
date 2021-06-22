package com.sejo.sales_management_system.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Optional<Staff> findStaffByFirstNameAndLastName(String firstName, String lastName);
}
