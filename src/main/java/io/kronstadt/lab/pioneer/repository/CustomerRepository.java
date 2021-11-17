package io.kronstadt.lab.pioneer.repository;


import io.kronstadt.lab.pioneer.model.Customer;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

//@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
    @Query("SELECT id, username, level, email FROM customer WHERE username = :username AND password = :password")
    Mono<Customer> findByUsernameAndPassword(String username, String password);

    @Query("SELECT id, username, level, email FROM customer WHERE username = :username")
    Mono<Customer> getProfile(String username);

    @Modifying
    @Query("UPDATE customer SET password = :password WHERE username = :username")
    Mono<Long> updatePassword(String username, String password);

    @Modifying
    @Query("UPDATE customer SET email = :email WHERE username = :username")
    Mono<Long> updateEmail(String username, String email);
}
