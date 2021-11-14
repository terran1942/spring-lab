package io.kronstadt.lab.pioneer.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Customer {
    private Long id;
    private String username;
    private String password;
    private int level;
    private String email;
}
