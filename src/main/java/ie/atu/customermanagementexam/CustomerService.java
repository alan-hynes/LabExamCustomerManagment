package ie.atu.customermanagementexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer AddCustomer(Customer customer) throws IllegalAccessException {
        if (!customer.isAdult()) {
            throw new IllegalAccessException("Customer must be over 18");
        }
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

}