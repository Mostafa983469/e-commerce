package com.example.ecommerce.service;

import com.example.ecommerce.models.Requests.LoginModel;
import com.example.ecommerce.models.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerce.repository.customerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    customerRepository customerRepository;

    public Customer Login(LoginModel Customer, HttpSession httpSession){
        Optional<List<Customer>> customer = customerRepository.login(Customer.getEmail(), Customer.getPassword());
        if (!customer.isPresent()||customer.get().size()==0) return null;
        httpSession.setAttribute("userName" ,customer.get().get(0).getName());
        httpSession.setAttribute("userId" ,customer.get().get(0).getId());
        return customer.get().get(0);
    }

    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }
}
