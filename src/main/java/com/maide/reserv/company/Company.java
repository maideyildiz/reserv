package com.maide.reserv.company;

import com.maide.reserv.reservation.Reservation;
import com.maide.reserv.user.User;
import com.maide.reserv.user.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
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

    public Company(String companyName, String companyEmail, Long companyPhone, String companyAddress,CompanyType type) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhone = companyPhone;
        this.companyAddress = companyAddress;
        this.type=type;
    }
}
