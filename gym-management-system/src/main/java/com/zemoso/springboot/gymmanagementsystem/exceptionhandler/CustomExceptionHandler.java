package com.zemoso.springboot.gymmanagementsystem.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public String handleException(CustomerNotIdentifiedException exc)
    {
        return "/customer/customer-not-found";
    }



}
