package com.zemoso.springboot.gymmanagementsystem.exceptionhandler;

public class CustomerNotIdentifiedException extends RuntimeException{

    public CustomerNotIdentifiedException() {
        super();
    }

    public CustomerNotIdentifiedException(String message) {
        super(message);
    }

    public CustomerNotIdentifiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotIdentifiedException(Throwable cause) {
        super(cause);
    }
}
