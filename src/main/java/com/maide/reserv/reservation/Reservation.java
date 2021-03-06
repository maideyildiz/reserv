package com.maide.reserv.reservation;

import com.maide.reserv.company.Company;
import com.maide.reserv.customer.Customer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Date beginingDate;
    private Date endDate;
    private int personCount;
    @ManyToMany(mappedBy = "reservations")
    private List<Customer> customerList;
    @ManyToMany(mappedBy = "reservationList")
    private List<Company> companyList;
}
