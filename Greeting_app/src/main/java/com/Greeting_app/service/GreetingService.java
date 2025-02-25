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

    public String getGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello " + firstName + "!";
        } else if (lastName != null) {
            return "Hello " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }



}
