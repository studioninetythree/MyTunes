package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MyTunes.domain.AlbumPrice;
import za.ac.cput.MyTunes.repository.ProductPriceRepository;
import za.ac.cput.MyTunes.services.IAlbumPriceService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumPriceService implements IAlbumPriceService {

    @Autowired
    ProductPriceRepository repository;

    @Override
    public AlbumPrice findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public AlbumPrice create(AlbumPrice albumPrice) {
        return repository.save(albumPrice);
    }

    @Override
    public AlbumPrice edit(AlbumPrice albumPrice) {
        return repository.save(albumPrice);
    }

    @Override
    public void delete(AlbumPrice albumPrice) {
        repository.delete(albumPrice);
    }

    @Override
    public List<AlbumPrice> findAll() {
        List<AlbumPrice> allAlbumPrices = new ArrayList<AlbumPrice>();

        Iterable<AlbumPrice> productPrices = repository.findAll();
        for (AlbumPrice albumPrice : productPrices) {
            allAlbumPrices.add(albumPrice);
        }
        return allAlbumPrices;
    }
}
