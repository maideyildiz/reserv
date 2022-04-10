package com.maide.reserv.seat;

import com.maide.reserv.Vehicle.Vehicle;
import com.maide.reserv.type.ReservationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Long seatNumber;
    private ReservationType seatType;

    @ManyToOne
    @JoinColumn(name="bus_id")
    private Vehicle bus;

    public Seat(Long seatNumber, ReservationType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }
}
