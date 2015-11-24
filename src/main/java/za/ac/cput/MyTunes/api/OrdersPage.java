package za.ac.cput.MyTunes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.MyTunes.domain.Order;
import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.services.IOrdersService;

import java.util.List;

@RestController
@RequestMapping(value="/api/**")
public class OrdersPage {

    @Autowired
    private IOrdersService service;

    @RequestMapping(value="/orderProducts/{id}", method= RequestMethod.GET)
    public List<OrderAlbum> getOrderProducts(@PathVariable Long id) {
        return service.getOrderProducts(id);
    }

    @RequestMapping(value = "/orders/", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listAllOrders() {
        List<Order> orderList = service.findAll();
        if(orderList.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Order order = service.findById(id);
        if (order == null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(@RequestBody Order order, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Order " + order.getId());

        service.create(order);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/order/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
        System.out.println("Updating Order " + id);

        Order currentOrder = service.findById(id);

        if (currentOrder==null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

        Order updatedOrder = new Order
                .Builder(currentOrder.getOrderStatus())
                .copy(currentOrder)
                .dateOrderPlaced(order.getDateOrderPlaced())
                .dateOrderPaid(order.getDateOrderPaid())
                .totalOrderPrice(order.getTotalOrderPrice())
                .orderProductList(order.getOrderAlbumList())
                .build();
        service.edit(updatedOrder);
        return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") long id, @RequestBody Order ord) {
        System.out.println("Fetching & Deleting Order with id " + id);

        Order order = service.findById(id);
        if (order == null) {
            System.out.println("Unable to delete. Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

        service.delete(order);
        return new ResponseEntity<Order>(HttpStatus.OK);
    }

}
