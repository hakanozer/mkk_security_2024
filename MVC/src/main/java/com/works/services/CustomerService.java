package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final TinkEncDec tinkEncDec;
    final HttpServletRequest req;

    public boolean customerLogin(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsIgnoreCase(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            Customer c = optionalCustomer.get();
            String dbPassword = tinkEncDec.decrypt( c.getPassword() );
            if (dbPassword.equals(customer.getPassword())) {
                req.getSession().setAttribute("customer", customer);
                return true;
            }
        }
        return false;
    }

}
