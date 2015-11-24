package za.ac.cput.MyTunes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.MyTunes.domain.AlbumPrice;
import za.ac.cput.MyTunes.services.IAlbumPriceService;

import java.util.List;

@RestController
@RequestMapping(value="/api/**")
public class ProductPricePage {

    @Autowired
    private IAlbumPriceService service;

    @RequestMapping(value = "/product-prices/", method = RequestMethod.GET)
    public ResponseEntity<List<AlbumPrice>> listAllProductPrices() {
        List<AlbumPrice> albumPriceList = service.findAll();
        if(albumPriceList.isEmpty()){
            return new ResponseEntity<List<AlbumPrice>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<AlbumPrice>>(albumPriceList, HttpStatus.OK);
    }

    @RequestMapping(value = "/product-prices/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumPrice> getProductPrice(@PathVariable("id") long id) {
        System.out.println("Fetching AlbumPriceResource with id " + id);
        AlbumPrice albumPrice = service.findById(id);
        if (albumPrice == null) {
            System.out.println("AlbumPriceResource with id " + id + " not found");
            return new ResponseEntity<AlbumPrice>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AlbumPrice>(albumPrice, HttpStatus.OK);
    }

    @RequestMapping(value = "/product-prices/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createProductPrice(@RequestBody AlbumPrice albumPrice, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating AlbumPriceResource " + albumPrice.getId());

        service.create(albumPrice);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/albumPrice/{id}").buildAndExpand(albumPrice.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product-prices/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AlbumPrice> updateProductPrice(@PathVariable("id") long id, @RequestBody AlbumPrice albumPrice) {
        System.out.println("Updating AlbumPriceResource " + id);

        AlbumPrice currentAlbumPrice = service.findById(id);

        if (currentAlbumPrice ==null) {
            System.out.println("AlbumPriceResource with id " + id + " not found");
            return new ResponseEntity<AlbumPrice>(HttpStatus.NOT_FOUND);
        }

        AlbumPrice updatedAlbumPrice = new AlbumPrice
                .Builder(currentAlbumPrice.getProductPrice())
                .copy(currentAlbumPrice)
                .dateFrom(albumPrice.getDateFrom())
                .productPrice(albumPrice.getProductPrice())
                .build();
        service.edit(updatedAlbumPrice);
        return new ResponseEntity<AlbumPrice>(updatedAlbumPrice, HttpStatus.OK);
    }

    @RequestMapping(value = "/product-prices/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AlbumPrice> deleteProductPrice(@PathVariable("id") long id, @RequestBody AlbumPrice propri) {
        System.out.println("Fetching & Deleting AlbumPriceResource with id " + id);

        AlbumPrice albumPrice = service.findById(id);
        if (albumPrice == null) {
            System.out.println("Unable to delete. AlbumPriceResource with id " + id + " not found");
            return new ResponseEntity<AlbumPrice>(HttpStatus.NOT_FOUND);
        }

        service.delete(albumPrice);
        return new ResponseEntity<AlbumPrice>(HttpStatus.OK);
    }

}
