package za.ac.cput.MyTunes.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MyTunes.domain.Orders;

public interface OrdersRepository extends CrudRepository<Orders,Long> {
}
