package com.pawcare.service;

import com.pawcare.entity.Customer;
import com.pawcare.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    public static List<Customer> getAllCustomers;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer updated) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(updated.getName());
            customer.setEmail(updated.getEmail());
            customer.setPhone(updated.getPhone());
            customer.setAddress(updated.getAddress());
            return customerRepository.save(customer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}