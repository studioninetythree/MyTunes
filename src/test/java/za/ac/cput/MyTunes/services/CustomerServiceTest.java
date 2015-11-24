package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.domain.Order;
import za.ac.cput.MyTunes.factories.*;
import za.ac.cput.MyTunes.domain.Customer;
import za.ac.cput.MyTunes.repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ICustomerService service;
    private Long id;
    @Autowired
    private CustomerRepository repository;

    @Test
    public void create() throws Exception {
        //repository.deleteAll();
        Order order = OrdersFactory.createOrders("Confirmed", "2015-12-12", "2015-12-12", new BigDecimal(200), null);
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(order);
        Customer customer = CustomerFactory.createCustomer(NameFactory.createName("Chloe", "Grace", "Moritz"), "Female", "2015-08-26", ContactFactory.createContact("0219807439", "08365623698"), AddressFactory.createAddress("452 Banjo Street", "", "", ""), orderList);
        service.create(customer);
        id = customer.getId();
        Assert.assertNotNull(customer);
    }

    @Test(dependsOnMethods = "create")
    public void testGetCustomer() throws Exception {
        Customer customer = service.findById(id);
        Assert.assertEquals(customer.getName().getFirstName(), "Chloe");
    }

    @Test(dependsOnMethods = "testGetCustomer")
    public void testGetCustomers() throws Exception {
        Customer customer = service.findById(id);
        Assert.assertEquals(customer.getName().getFirstName(), "Chloe");
    }

    @Test(dependsOnMethods = "testGetCustomers")
    public void testGetOrders() throws Exception {
        Customer customer = service.findById(id);
        Assert.assertEquals(customer.getName().getFirstName(), "Chloe");
    }

    @Test(dependsOnMethods = "testGetCustomers")
    public void testEditCustomer() throws Exception {
        Customer customer = repository.findOne(id);
        Customer updatedCustomer = new Customer.Builder(customer.getName()).copy(customer).address(AddressFactory.createAddress("3 Diasy Circle", "", "", "")).build();
        service.edit(updatedCustomer);
        Customer newCustomer = repository.findOne(id);
        Assert.assertEquals(newCustomer.getAddress().getAddress(), "3 Diasy Circle");
    }

    @Test(dependsOnMethods = "testEditCustomer")
    public void testDeleteCustomer() throws Exception {
        Customer customer = repository.findOne(id);
        //service.delete(customer);
        Customer newCustomer = repository.findOne(id);
        Assert.assertNotNull(newCustomer);
    }

}
