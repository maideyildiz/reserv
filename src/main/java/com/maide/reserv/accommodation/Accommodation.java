package com.maide.reserv.accommodation;

import com.maide.reserv.company.Company;

import javax.persistence.*;

@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String address;
    private Long phone;
    private String email;

}
