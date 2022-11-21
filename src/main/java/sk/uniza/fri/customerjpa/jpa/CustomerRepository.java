package sk.uniza.fri.customerjpa.jpa;

import org.springframework.data.repository.CrudRepository;
import sk.uniza.fri.customerjpa.customer.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByFirstName(String first);
    Customer findById(long id);

}
