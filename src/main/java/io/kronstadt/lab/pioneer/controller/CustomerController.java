package io.kronstadt.lab.pioneer.controller;

import io.kronstadt.lab.pioneer.model.Customer;
import io.kronstadt.lab.pioneer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public Flux<Customer> findAll(){
        return this.customerService.findAll();
    }

    @GetMapping("/customer")
    public Mono<Customer> find(String username, String password){
        return this.customerService.findCustomer(username, password);
    }

    @PatchMapping("/customer/password")
    public Mono<Long> updatePassword(String username, String password){
        return this.customerService.updatePassword(username, password);
    }

    @PatchMapping("/customer/email")
    public Mono<Customer> updateEmail(String username, String email){
        return this.customerService.updateEmail(username, email);
    }
}
