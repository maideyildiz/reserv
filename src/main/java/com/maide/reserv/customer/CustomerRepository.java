package com.maide.reserv.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c from Customer c where c.email=?1")
    Customer findByEmail(String email);
}