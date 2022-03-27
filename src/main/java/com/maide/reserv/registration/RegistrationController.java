package com.maide.reserv.registration;

import com.maide.reserv.company.Company;
import com.maide.reserv.company.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/reserv/registration")
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    private final CompanyService companyService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @PostMapping("/company")
    public String registerAsCompany(@RequestBody RegistrationRequest request){
        return registrationService.registerAsCompany(request);
    }
    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) throws InterruptedException {
        return registrationService.confirmToken(token);
    }

}
