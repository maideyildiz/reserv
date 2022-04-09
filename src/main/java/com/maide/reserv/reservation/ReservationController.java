package com.maide.reserv.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/reserv/reservation")
@AllArgsConstructor
public class ReservationController {

    @PostMapping("reserve")
    public void makeReservation(){

    }
    @GetMapping("myReservations")
    public void getCustomerReservations(){

    }
    @GetMapping("companyReservations")
    public void getCompanyReservations(){

    }
    @GetMapping("/deleteReservation")
    public void deleteReservation(){

    }
    @PutMapping("/editReservation")
    public void editReservation(){

    }
}
