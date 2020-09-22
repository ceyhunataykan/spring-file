package com.ca.springfileexample.entity;

import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {
    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String email;
    @Column(length = 10)
    private String phone;
}
