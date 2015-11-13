package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MyTunes.domain.Album;
import za.ac.cput.MyTunes.repository.AlbumRepository;
import za.ac.cput.MyTunes.services.IAlbumService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService implements IAlbumService {

    @Autowired
    AlbumRepository repository;

    @Override
    public Album findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Album create(Album album) {
        return repository.save(album);
    }

    @Override
    public Album edit(Album album) {
        return repository.save(album);
    }

    @Override
    public void delete(Album album) {
        repository.delete(album);
    }

    @Override
    public List<Album> findAll() {
        List<Album> allAlbums = new ArrayList<Album>();

        Iterable<Album> products = repository.findAll();
        for (Album album : products) {
            allAlbums.add(album);
        }
        return allAlbums;
    }

}
