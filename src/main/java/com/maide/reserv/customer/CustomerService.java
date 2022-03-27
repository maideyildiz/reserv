package com.maide.reserv.customer;

import com.maide.reserv.registration.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {
    public final CustomerRepository customerRepository;
    public void createCustomer(Customer customer){
        boolean customerExist=customerRepository.findByEmail(customer.getEmail()).isPresent();
        if(customerExist){
            throw new IllegalStateException("email already taken");
        }
        customerRepository.save(customer);
    }
}
