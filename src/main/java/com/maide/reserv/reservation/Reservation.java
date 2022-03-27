package com.maide.reserv.reservation;

import com.maide.reserv.company.Company;
import com.maide.reserv.customer.Customer;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    @ManyToMany(mappedBy = "reservations")
    private List<Customer> customerList;
    @ManyToMany(mappedBy = "reservationList")
    private List<Company> companyList;
}
