package com.example.lab11.Model;

import jakarta.persistence.*;
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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "category id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;
    @NotEmpty(message = "title cannot be empty")
    @Size(min = 5)
    @Column(columnDefinition = "varchar(20) not null unique")
    private String title;
    @NotEmpty(message = "content cannot be empty")
    @Size(min = 100)
    @Column(columnDefinition = "varchar(500) not null ")
    private String content;
    @NotNull(message = "user id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @NotNull(message = "date cannot be empty")
    @Column(columnDefinition = " date not null")
    private Date publishDate;
}
