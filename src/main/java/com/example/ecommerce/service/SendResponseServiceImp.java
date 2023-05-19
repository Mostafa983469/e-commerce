package com.example.ecommerce.service;


import com.example.ecommerce.models.Responses.SendResponse;
import com.example.ecommerce.models.Responses.SendResponseWithObject;
import org.springframework.stereotype.Service;


@Service
public class SendResponseServiceImp<T>  {

    public SendResponse CreateResponse(String status, String message) {
        return  new SendResponse(status,message);
    }


    public <T> SendResponseWithObject CreateResponseWithBody(String status, String message, T body) {
        return new SendResponseWithObject<T>(status,message,body);
    }


}
