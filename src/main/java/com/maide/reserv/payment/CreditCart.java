package com.maide.reserv.payment;
import com.maide.reserv.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Entity
public class CreditCart implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String nameSurname;
    private Long cardNumber;
    private Integer cvc;
    private Date lastDay;
    @ManyToMany(mappedBy = "cards")
    private List<Customer> customers;

    public CreditCart() {
    }

    public CreditCart(Long id, String nameSurname, Long cardNumber, Integer cvc, Date lastDay, List<Customer> customers) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.lastDay = lastDay;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    public Date getLastDay() {
        return lastDay;
    }

    public void setLastDay(Date lastDay) {
        this.lastDay = lastDay;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
