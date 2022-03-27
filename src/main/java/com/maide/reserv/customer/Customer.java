package com.maide.reserv.customer;

import com.maide.reserv.payment.CreditCart;
import com.maide.reserv.reservation.Reservation;
import com.maide.reserv.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    public Customer() {
    }

    public Customer(String name, String surname, String address, Long phone, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CreditCart> getCards() {
        return cards;
    }

    public void setCards(List<CreditCart> cards) {
        this.cards = cards;
    }


}
