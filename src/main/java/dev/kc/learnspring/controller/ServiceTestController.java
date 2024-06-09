package dev.kc.learnspring.controller;

import dev.kc.learnspring.service.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceTestController {

    public final IService service;

    public ServiceTestController(IService service) {
        this.service = service;
    }

    @GetMapping("/api/greet")
    public String greetApi(){
        return service.greetMessage();
    }
}
