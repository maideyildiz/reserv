package com.maide.reserv.customer;

import com.maide.reserv.payment.CreditCart;
import com.maide.reserv.reservation.Reservation;
import com.maide.reserv.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String surname;
    private String address;
    private Long phone;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "CustomerCards",
            joinColumns = @JoinColumn(name = "customerId"),
            inverseJoinColumns = @JoinColumn(name = "cardId")
    )
    @Column(nullable = true,updatable = true)
    private List<CreditCart> cards;
    @ManyToMany
    @JoinTable(
            name = "CustomerReservations",
            joinColumns = @JoinColumn(name = "reservationId"),
            inverseJoinColumns = @JoinColumn(name = "customerId")
    )
    private List<Reservation> reservations;
    public Customer(String name, String surname, String address, Long phone, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}
