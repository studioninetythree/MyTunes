package za.ac.cput.MyTunes.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MyTunes.domain.Order;

public interface OrdersRepository extends CrudRepository<Order,Long> {
}
