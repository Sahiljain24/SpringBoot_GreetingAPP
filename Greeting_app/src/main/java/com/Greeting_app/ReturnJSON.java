package com.Greeting_app;


import com.Greeting_app.Entity.GreetingEntity;
import com.Greeting_app.repositary.GreetingRepositary;
import com.Greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReturnJSON {

    private final GreetingService greetingService;
    private final GreetingRepositary greetingRepositary;
    @Autowired
    public ReturnJSON(GreetingService greetingService, GreetingRepositary greetingRepositary) {
        this.greetingService=greetingService;

        this.greetingRepositary =greetingRepositary;

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
    @GetMapping("/service/hello/post/fullName")
    public String greet(){   //greet based on first and last name
        return greetingService.getGreeting("Sahil","jain");
    }
    @GetMapping("/service/hello/post/firstName")
    public String greet1(){   //greet based on first and last name
        return greetingService.getGreeting("Sahil",null);
    }
    @GetMapping("/service/hello/post/lastName")
    public String greet2(){   //greet based on first and last name
        return greetingService.getGreeting(null,"jain");
    }
    @GetMapping("/service/hello/post/noName")
    public String greet3(){   //greet based on first and last name
        return greetingService.getGreeting(null,null);
    }

   @PostMapping("api/save/greeting")
    public GreetingEntity saveGreeting(@RequestParam String message){
       GreetingEntity gn= new GreetingEntity(message);
        return greetingRepositary.save(gn);

   }
   @GetMapping("api/get/greeting/{id}")
    public GreetingEntity getEntityById(@PathVariable Long id){
        return greetingRepositary.findById(id)
                .orElseThrow(()->new RuntimeException("matching record not found0 " + id));
   }



}
