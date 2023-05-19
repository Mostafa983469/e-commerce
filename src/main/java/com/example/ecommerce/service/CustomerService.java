package com.example.ecommerce.service;

import com.example.ecommerce.models.Customer;
import com.example.ecommerce.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    customerRepository customerRepository;

    public boolean addCustomer(Customer customer){
        if(findUserByEmail(customer.getEmail())!=null) return false;
        customerRepository.save(customer);
        return true;
    }

    public boolean updateCustomer(Customer customer){
        Optional<Customer> currentCustomer = customerRepository.findById(customer.getId());
        if (currentCustomer.isEmpty()) return false;
        if (!currentCustomer.get().getEmail().equals(customer.getEmail()))
            if(findUserByEmail(customer.getEmail())!=null)  return false;
        customerRepository.save(customer);
        return true;
    }

    public List<Customer> searchByName(String name){
        List<Customer> customers = customerRepository.findByName(name);
        if (customers.isEmpty()) return null;
        return customers;
    }

    public Customer findUserByEmail(String email) {

        Optional<List<Customer>> Customer=customerRepository.findByEmail(email);
        if(Customer.isPresent()&&Customer.get().size()>0){
            return Customer.get().get(0);
        }
        return null;
    }

}
