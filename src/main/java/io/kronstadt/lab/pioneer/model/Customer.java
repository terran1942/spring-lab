package io.kronstadt.lab.pioneer.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table
public class Customer {
    @Id
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private int level;
    @Column
    private String email;
}
