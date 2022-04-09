package com.maide.reserv.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/reserv/company/restaurant")
@AllArgsConstructor
public class RestaurantController {
    @GetMapping("reservTable")
    public void reserv(){

    }
}
