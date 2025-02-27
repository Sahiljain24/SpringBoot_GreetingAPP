package com.Greeting_app.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private String message="Hello from service class";

    public String setMessage(String message) {
        this.message = message;
        return message;
    }

    public String getMessage() {
        return message;
    }




}
