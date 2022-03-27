package com.maide.reserv.company;

import com.maide.reserv.user.User;

import javax.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String companyName;
    private String companyAddress;

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
