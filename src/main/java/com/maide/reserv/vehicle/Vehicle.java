package com.maide.reserv.vehicle;

import com.maide.reserv.seat.Seat;
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
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String busLicensePlate;
    private Integer seatCount;
    private String driverName;
    private String serverName;
    @OneToMany(mappedBy = "seat")
    private List<Seat> seats;


    public Vehicle(String busLicensePlate, Integer seatCount, String driverName, String serverName) {
        this.busLicensePlate = busLicensePlate;
        this.seatCount = seatCount;
        this.driverName = driverName;
        this.serverName = serverName;
    }
}
