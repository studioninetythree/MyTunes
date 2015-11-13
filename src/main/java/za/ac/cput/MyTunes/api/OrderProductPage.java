package za.ac.cput.MyTunes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.services.IOrderAlbumService;

import java.util.List;

@RestController
@RequestMapping(value="/api/**")
public class OrderProductPage {

    @Autowired
    private IOrderAlbumService service;

    @RequestMapping(value = "/orderProducts/", method = RequestMethod.GET)
    public ResponseEntity<List<OrderAlbum>> listAllOrderProducts() {
        List<OrderAlbum> orderAlbumList = service.findAll();
        if(orderAlbumList.isEmpty()){
            return new ResponseEntity<List<OrderAlbum>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<OrderAlbum>>(orderAlbumList, HttpStatus.OK);
    }

    @RequestMapping(value = "/orderProduct/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderAlbum> getOrderProduct(@PathVariable("id") long id) {
        System.out.println("Fetching OrderAlbum with id " + id);
        OrderAlbum orderAlbum = service.findById(id);
        if (orderAlbum == null) {
            System.out.println("OrderAlbum with id " + id + " not found");
            return new ResponseEntity<OrderAlbum>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderAlbum>(orderAlbum, HttpStatus.OK);
    }

    @RequestMapping(value = "/orderProduct/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrderProduct(@RequestBody OrderAlbum orderAlbum, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating OrderAlbum " + orderAlbum.getId());

        service.create(orderAlbum);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/orderAlbum/{id}").buildAndExpand(orderAlbum.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/orderProduct/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrderAlbum> updateOrderProduct(@PathVariable("id") long id, @RequestBody OrderAlbum orderAlbum) {
        System.out.println("Updating OrderAlbum " + id);

        OrderAlbum currentOrderAlbum = service.findById(id);

        if (currentOrderAlbum ==null) {
            System.out.println("OrderAlbum with id " + id + " not found");
            return new ResponseEntity<OrderAlbum>(HttpStatus.NOT_FOUND);
        }

        OrderAlbum updatedOrderAlbum = new OrderAlbum
                .Builder(currentOrderAlbum.getQuantity())
                .copy(currentOrderAlbum)
                .quantity(orderAlbum.getQuantity())
                .build();
        service.edit(updatedOrderAlbum);
        return new ResponseEntity<OrderAlbum>(updatedOrderAlbum, HttpStatus.OK);
    }

    @RequestMapping(value = "/orderProduct/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrderAlbum> deleteOrderProduct(@PathVariable("id") long id, @RequestBody OrderAlbum ord) {
        System.out.println("Fetching & Deleting OrderAlbum with id " + id);

        OrderAlbum orderAlbum = service.findById(id);
        if (orderAlbum == null) {
            System.out.println("Unable to delete. OrderAlbum with id " + id + " not found");
            return new ResponseEntity<OrderAlbum>(HttpStatus.NOT_FOUND);
        }

        service.delete(orderAlbum);
        return new ResponseEntity<OrderAlbum>(HttpStatus.OK);
    }

}
