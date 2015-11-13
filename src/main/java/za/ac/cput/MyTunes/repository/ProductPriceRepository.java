package za.ac.cput.MyTunes.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MyTunes.domain.AlbumPrice;

public interface ProductPriceRepository extends CrudRepository<AlbumPrice,Long> {
}
