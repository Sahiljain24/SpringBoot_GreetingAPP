package com.Greeting_app;


import org.springframework.web.bind.annotation.*;

@RestController
public class ReturnJSON {

    @GetMapping("/hello")
    public Message hello(){
        return new Message("hello from bridgelabz");
    }
    @GetMapping("/hello/querry")
    public Message hello1(@RequestParam String name){
        return new Message("hello from bridgelabz" + name);
    }
    @GetMapping("/hello/path/{name}")
    public Message hello2(@PathVariable String name){
        return new Message("hello from bridgelabz " + name);
    }
    @PostMapping("/hello/body")
    public Message hello(@RequestBody Message message){
        return message;
    }
    @PutMapping("/hello/update/{name}")
    public Message hello(@PathVariable String name, @RequestBody Message message){
        return new Message( name + message.getMessage());
    }
    @DeleteMapping("/hello/delete/{name}")
    public Message hello(@PathVariable String name){
        return new Message("Deleletd " +name+ " from bridgelabz successfully");
    }



}
