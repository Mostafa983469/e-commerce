package com.example.ecommerce.controller;

import com.example.ecommerce.models.Customer;
import com.example.ecommerce.models.Requests.LoginModel;
import com.example.ecommerce.service.AuthenticationService;
import com.example.ecommerce.service.SendResponseEntityImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService ;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    SendResponseEntityImp sendResponseEntity;


    @PostMapping("login")
    public ResponseEntity Login(@RequestBody LoginModel user){
        Customer customer = authenticationService.Login(user,httpSession);
        if (customer==null) {
            return sendResponseEntity.SendResponseEntity("fail", "invalid credentials"
                    , HttpStatus.NOT_FOUND);
        }
        return  sendResponseEntity.SendResponseEntity("success","login successfully"
                ,HttpStatus.OK);
    }

    @GetMapping("logout")
    public ResponseEntity logout(){
        authenticationService.logout(httpSession);
        return new ResponseEntity(HttpStatus.OK);
    }
}
