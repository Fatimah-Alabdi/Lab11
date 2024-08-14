package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "username cannot be empty")
    @Size(min = 5)
    @Column(columnDefinition = "varchar(15) not null unique")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = " varchar(10) not null")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotNull(message = "date cannot be empty")
    @Column(columnDefinition = " date not null")
    private Date registrationDate;

}
