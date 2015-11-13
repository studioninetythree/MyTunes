package za.ac.cput.MyTunes.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MyTunes.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
