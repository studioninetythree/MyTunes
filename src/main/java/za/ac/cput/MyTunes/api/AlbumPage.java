package za.ac.cput.MyTunes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.MyTunes.domain.Album;
import za.ac.cput.MyTunes.services.IAlbumService;

import java.util.List;

@RestController
@RequestMapping(value="/api/**")
public class AlbumPage {

    @Autowired
    private IAlbumService service;

    @RequestMapping(value = "/albums/", method = RequestMethod.GET)
    public ResponseEntity<List<Album>> listAllProducts() {
        List<Album> albumList = service.findAll();
        if(albumList.isEmpty()){
            return new ResponseEntity<List<Album>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Album>>(albumList, HttpStatus.OK);
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Album> getProduct(@PathVariable("id") long id) {
        System.out.println("Fetching Album with id " + id);
        Album album = service.findById(id);
        if (album == null) {
            System.out.println("Album with id " + id + " not found");
            return new ResponseEntity<Album>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Album>(album, HttpStatus.OK);
    }

    @RequestMapping(value = "/album/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createAlbum(@RequestBody Album album, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Album " + album.getId());

        service.create(album);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/album/{id}").buildAndExpand(album.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/albums/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Album> updateAlbum(@PathVariable("id") long id, @RequestBody Album album) {
        System.out.println("Updating Album " + id);

        Album currentAlbum = service.findById(id);

        if (currentAlbum ==null) {
            System.out.println("Album with id " + id + " not found");
            return new ResponseEntity<Album>(HttpStatus.NOT_FOUND);
        }

        Album updatedAlbum = new Album
                .Builder(currentAlbum.getName())
                .copy(currentAlbum)
                .name(album.getName())
                .artist(album.getArtist())
                .price(album.getPrice())
                .description(album.getDescription())
                .orderAlbumList(album.getOrderAlbumList())
                .productPriceList(album.getAlbumPriceList())
                .build();
        service.edit(updatedAlbum);
        return new ResponseEntity<Album>(updatedAlbum, HttpStatus.OK);
    }

    @RequestMapping(value = "/album/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Album> deleteAlbum(@PathVariable("id") long id, @RequestBody Album alb) {
        System.out.println("Fetching & Deleting Album with id " + id);

        Album album = service.findById(id);
        if (album == null) {
            System.out.println("Unable to delete. Album with id " + id + " not found");
            return new ResponseEntity<Album>(HttpStatus.NOT_FOUND);
        }

        service.delete(album);
        return new ResponseEntity<Album>(HttpStatus.OK);
    }

}
