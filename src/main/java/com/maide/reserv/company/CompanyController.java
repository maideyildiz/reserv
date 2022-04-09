package com.maide.reserv.company;

import com.maide.reserv.accommodation.Accommodation;
import com.maide.reserv.transportation.Transportation;
import com.maide.reserv.vacation.Vacation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(path = "/api/reserv/company")
@AllArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("profile")
    public <T> Object getProfile(Company company){
        return companyService.getProfile(company);
    }
}
