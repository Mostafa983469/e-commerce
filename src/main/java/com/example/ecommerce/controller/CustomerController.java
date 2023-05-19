package com.example.ecommerce.controller;

import com.example.ecommerce.models.Customer;
import com.example.ecommerce.service.CustomerService;
import com.example.ecommerce.service.SendResponseEntityImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    SendResponseEntityImp sendResponseEntity;

    @Autowired
    private HttpSession httpSession;

    @PostMapping("register")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        boolean state = customerService.addCustomer(customer);
        if (!state)
        {
            return sendResponseEntity.SendResponseEntity("fail", "email is used"
                    , HttpStatus.BAD_REQUEST);
        }
        return  sendResponseEntity.SendResponseEntity("success","create user successfully"
                ,HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity updateCustomer(@RequestBody Customer customer){
        boolean state = customerService.updateCustomer(customer);
        if (!state)
        {
            return sendResponseEntity.SendResponseEntity("fail",
                    "user not found or email is not unique", HttpStatus.BAD_REQUEST);
        }
        return  sendResponseEntity.SendResponseEntity("success","update user successfully"
                ,HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity searchByName(@RequestParam String name){
        List<Customer> customers = customerService.searchByName(name);
        if (customers==null)
        {
            return sendResponseEntity.SendResponseEntity("fail",
                    "no users with this name", HttpStatus.NOT_FOUND);
        }
        return  sendResponseEntity.SendResponseEntityWithBody("success","result of search"
                ,HttpStatus.OK,customers);
    }




}
