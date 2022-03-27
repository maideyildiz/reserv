package com.maide.reserv.vacation;

import javax.persistence.*;

@Entity
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String address;
    private Long phone;
    private String email;
}
