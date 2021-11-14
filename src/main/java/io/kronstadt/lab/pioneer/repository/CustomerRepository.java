package io.kronstadt.lab.pioneer.repository;


import io.kronstadt.lab.pioneer.model.Customer;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

//@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
    @Query("SELECT id, username, level FROM customer WHERE username = :username AND password = :password")
    Mono<Customer> find(String username, String password);

    @Modifying
    @Query("UPDATE customer SET password = :password WHERE username = :username")
    Mono<Customer> updatePassword(String username, String password);
}
