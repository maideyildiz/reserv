package com.maide.reserv.company;

import com.maide.reserv.accommodation.Accommodation;
import com.maide.reserv.accommodation.AccommodationRepository;
import com.maide.reserv.restaurant.Restaurant;
import com.maide.reserv.restaurant.RestaurantRepository;
import com.maide.reserv.transportation.Transportation;
import com.maide.reserv.transportation.TransportationRepository;
import com.maide.reserv.user.User;
import com.maide.reserv.vacation.Vacation;
import com.maide.reserv.vacation.VacationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    private Integer findCompanyType(CompanyType type){
        if(type==CompanyType.VACATION){
            return 1;
        }
        else if (type==CompanyType.TRANSPORTATION){
            return 2;
        }
        else if (type==CompanyType.RESTAURANT){
            return 3;
        }
        else if (type==CompanyType.ACCOMMODATION){
            return 4;
        }
        return 0;
    }

    public <T> Object getProfile(Company company){
        Integer type=findCompanyType(company.getType());
        switch (type) {
            case 1:
                return vacationRepository.getById(company.getId());
            case 2:
                return transportationRepository.getById(company.getId());
            case 3:
                return restaurantRepository.getById(company.getId());
            case 4:
                return accommodationRepository.getById(company.getId());
            default:
                return companyRepository.getById(company.getId());
        }
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
        switch (user.getBusinessType()) {
            case 1:
                setVacationCompany(user);
                break;
            case 2:
                setTransportationCompany(user);
                break;
            case 3:
                setRestaurantCompany(user);
                break;
            case 4:
                setAccommodationCompany(user);
                break;
            default:
                userToCompany(user);
                break;
        }
    }
}
