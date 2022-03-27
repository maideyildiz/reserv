package com.maide.reserv.customer;

import com.maide.reserv.payment.CreditCart;
import com.maide.reserv.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
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

    public Customer() {
    }

    public Customer(Long phone,String email) {
        this.phone = phone;
        this.email=email;
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


    public List<CreditCart> getCards() {
        return cards;
    }

    public void setCards(List<CreditCart> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", phone=" + phone +
                ", cards=" + cards +
                '}';
    }
}
