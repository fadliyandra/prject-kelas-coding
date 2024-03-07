package com.testproject.data.entities;

import org.hibernate.annotations.Comment;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tbl_user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "fisrt name harus ada")
    @Column(nullable = false, length = 100)
    private String firstName;

    @NotEmpty(message = "last name harus ada")
    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @NotEmpty(message = "email harus ada")
    @Email(message = "invalid email")
    @Column(unique = true,length = 255, nullable = false)
    private String email;

    @NotEmpty(message = "password is rqueired")
    @Column(length = 255, nullable = false)
    private String password;

    


}
