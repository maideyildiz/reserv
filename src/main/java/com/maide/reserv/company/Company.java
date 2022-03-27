package com.maide.reserv.company;

import com.maide.reserv.reservation.Reservation;
import com.maide.reserv.user.User;
import com.maide.reserv.user.UserRole;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String companyName;
    private String companyEmail;
    private Long companyPhone;
    private String companyAddress;
    @Enumerated(EnumType.STRING)
    private CompanyType type;
    @ManyToMany
    @JoinTable(
            name = "CompanyReservations",
            joinColumns = @JoinColumn(name = "reservationId"),
            inverseJoinColumns = @JoinColumn(name = "companyId")
    )
    private List<Reservation> reservationList;
    public Company() {
    }

    public Company(String companyName, String companyEmail, Long companyPhone, String companyAddress,CompanyType type) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhone = companyPhone;
        this.companyAddress = companyAddress;
        this.type=type;
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

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public Long getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(Long companyPhone) {
        this.companyPhone = companyPhone;
    }
}
