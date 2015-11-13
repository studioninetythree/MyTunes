package za.ac.cput.MyTunes.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MyTunes.domain.OrderAlbum;

public interface OrderProductRepository extends CrudRepository<OrderAlbum,Long> {
}
