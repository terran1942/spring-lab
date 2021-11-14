package io.kronstadt.lab.pioneer.service;

import io.kronstadt.lab.pioneer.model.Customer;
import io.kronstadt.lab.pioneer.repository.CustomerRepository;
import io.kronstadt.lab.pioneer.util.Digest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Flux<Customer> findAll(){
        return this.customerRepository.findAll();
    }

    public Mono<Customer> find(String username, String password){
        return this.customerRepository.find(username, password);
    }

    public Mono<Customer> updatePassword(String username, String newPassword){
        try {
            return this.customerRepository.updatePassword(username, Digest.sha256(newPassword));
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
            return Mono.error(e);
        }
    }
}
