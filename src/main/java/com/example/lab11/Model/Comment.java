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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "user id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @NotNull(message = "post id cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer postId;
    @NotEmpty(message = "content cannot be empty")
    @Size(min = 10)
    @Column(columnDefinition = "varchar(200) not null")
    private String content;
    @NotNull(message = "date cannot be empty")
    @Column(columnDefinition = " date not null")
    private Date commentDate;
}
