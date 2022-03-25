package com.maide.reserv.customer;

import com.maide.reserv.payment.CreditCart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Long phone;
    private Date dateOfBirth;
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

    public Customer(Long id, Long phone, Date dateOfBirth) {
        this.id = id;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
                ", dateOfBirth=" + dateOfBirth +
                ", cards=" + cards +
                '}';
    }
}
