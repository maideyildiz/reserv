package com.maide.reserv;
import static org.assertj.core.api.Assertions.assertThat;

import com.maide.reserv.customer.Customer;
import com.maide.reserv.customer.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository repo;
    /*@Test
    public void testCreateUser() {
        Customer customer = new Customer();
        customer.setEmail("maidey@mail.com");
        customer.setPassword("123");
        customer.setName("Maide");

        Customer savedUser = repo.save(customer);

        Customer existUser = entityManager.find(Customer.class, savedUser.getId());

        assertThat(customer.getEmail()).isEqualTo(existUser.getEmail());

    }*/
    @Test
    public void testFindUserByEmail(){
        String email="mbgghgh";
        Customer customer=repo.findByEmail(email);
        assertThat(customer).isNotNull();
    }
}
