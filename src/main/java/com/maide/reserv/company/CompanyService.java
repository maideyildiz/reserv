package com.maide.reserv.company;

import com.maide.reserv.customer.Customer;
import com.maide.reserv.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyService {
    public final CompanyRepository companyRepository;
    public void createCompany(Company company){
        boolean customerExist=companyRepository.findByCompanyEmail(company.getCompanyEmail()).isPresent();
        if(customerExist){
            throw new IllegalStateException("email already taken");
        }
        companyRepository.save(company);
    }
}
