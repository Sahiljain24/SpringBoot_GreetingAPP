package com.Greeting_app;


import com.Greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReturnJSON {

    private final GreetingService greetingService;

    @Autowired
    public ReturnJSON(GreetingService greetingService) {
        this.greetingService=greetingService;
    }

    @GetMapping("/hello")
    public Message hello0(){
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
    @GetMapping("/service/hello")
    public String hello(){
        return greetingService.getMessage();
    }
    @GetMapping("/service/hello/post")
    public String hello6(){
        return greetingService.setMessage("HEllo post service by sahil");
    }


}
