package com.maide.reserv.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    public void createReservation(Reservation reservation){
        boolean reservationExist=reservationRepository.findReservationById(reservation.getId()).isPresent();
        if(reservationExist){
            throw new IllegalStateException("reservation already exist");
        }
        reservationRepository.save(reservation);
    }
}
