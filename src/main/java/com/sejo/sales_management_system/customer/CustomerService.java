package com.sejo.sales_management_system.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Boolean createCustomer(Customer customer) {

        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());

        if (customerOptional.isPresent()){
            throw new IllegalStateException("Email already in use");
        }else{
            customerRepository.save(customer);
            return true;
        }


    }
}
