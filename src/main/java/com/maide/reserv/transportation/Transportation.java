package com.maide.reserv.transportation;

import javax.persistence.*;

@Entity
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String address;
    private Long phone;
    private String email;
}
