package com.maide.reserv.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository _repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer=_repo.findByEmail(email);
        if(customer==null){
            throw new UsernameNotFoundException("User not found!");
        }
        return new CustomerDetails(customer);
    }
}
