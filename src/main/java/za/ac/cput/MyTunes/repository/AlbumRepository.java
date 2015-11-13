package za.ac.cput.MyTunes.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.MyTunes.domain.Album;

public interface AlbumRepository extends CrudRepository<Album,Long> {
}
