package com.maide.reserv.company;

import com.maide.reserv.accommodation.Accommodation;
import com.maide.reserv.accommodation.AccommodationRepository;
import com.maide.reserv.customer.Customer;
import com.maide.reserv.customer.CustomerRepository;
import com.maide.reserv.restaurant.Restaurant;
import com.maide.reserv.restaurant.RestaurantRepository;
import com.maide.reserv.transportation.Transportation;
import com.maide.reserv.transportation.TransportationRepository;
import com.maide.reserv.user.User;
import com.maide.reserv.vacation.Vacation;
import com.maide.reserv.vacation.VacationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyService {
    public final CompanyRepository companyRepository;
    public final AccommodationRepository accommodationRepository;
    public final RestaurantRepository restaurantRepository;
    public final TransportationRepository transportationRepository;
    public final VacationRepository vacationRepository;

    public Company findCompany(String email){
        boolean companyExist=companyRepository.findByCompanyEmail(email).isPresent();
        if(companyExist){
            throw new IllegalStateException("email not found");
        }
        return companyRepository.findByCompanyEmail(email).get();
    }

    public void createCompany(Company company){
        boolean companyExist=companyRepository.findByCompanyEmail(company.getCompanyEmail()).isPresent();
        if(companyExist){
            throw new IllegalStateException("email already taken");
        }
        companyRepository.save(company);
    }
    private void updateCompanyType(Company company,CompanyType type){
        boolean companyExist=companyRepository.findByCompanyEmail(company.getCompanyEmail()).isPresent();
        if(companyExist==false){
            throw new IllegalStateException("email not found");
        }
        company.setType(type);
        companyRepository.save(company);
    }
    private void userToCompany(User user){
        createCompany(
                new Company(
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getAddress(),
                        CompanyType.EMPTY
                )
        );
    }
    private void setAccommodationCompany(User user){
        accommodationRepository.save(
                new Accommodation(
                        user.getName(),
                        user.getAddress(),
                        user.getPhone(),
                        user.getEmail()

                )
        );
    }
    private void setRestaurantCompany(User user){
        restaurantRepository.save(
                new Restaurant(
                        user.getName(),
                        user.getAddress(),
                        user.getPhone(),
                        user.getEmail()
                )
        );
    }
    private void setTransportationCompany(User user) {
        transportationRepository.save(
                new Transportation(
                        user.getName(),
                        user.getAddress(),
                        user.getPhone(),
                        user.getEmail()
                )
        );
    }
    private void setVacationCompany(User user){
        vacationRepository.save(
                new Vacation(
                        user.getName(),
                        user.getAddress(),
                        user.getPhone(),
                        user.getEmail()
                )
        );
    }
    public void separateBusiness(User user){
        userToCompany(user);
        if(user.getBusinessType()==0){
            setAccommodationCompany(user);
        }
        else if(user.getBusinessType()==1){
            setRestaurantCompany(user);
        }
        else if(user.getBusinessType()==2){
            setTransportationCompany(user);
        }
        else if(user.getBusinessType()==3){
            setVacationCompany(user);
        }
        else{
            createCompany(
                    new Company(
                            user.getName(),
                            user.getEmail(),
                            user.getPhone(),
                            user.getAddress(),
                            CompanyType.EMPTY
                    )
            );
        }
    }
}
