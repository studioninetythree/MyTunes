package za.ac.cput.MyTunes.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.factories.AddressFactory;
import za.ac.cput.MyTunes.factories.ContactFactory;
import za.ac.cput.MyTunes.factories.CustomerFactory;
import za.ac.cput.MyTunes.factories.NameFactory;
import za.ac.cput.MyTunes.domain.Customer;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CustomerCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    CustomerRepository repository;

    @Test
    public void testCreate() throws Exception {
        repository.deleteAll();
        Customer customer = CustomerFactory.createCustomer(NameFactory.createName("Mark", "Denver", "Jones"), "Male", "2015-01-04", ContactFactory.createContact("0112003658", "0822255693"), AddressFactory.createAddress("10 Freedom Road", "", "", ""), null);
        repository.save(customer);
        id = customer.getId();
        Assert.assertNotNull(customer.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Customer customer = repository.findOne(id);
        Assert.assertEquals(customer.getName().getFirstName(), "Mark");
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Customer customer = repository.findOne(id);
        Customer newCustomer = new Customer.Builder(customer.getName()).copy(customer).address(AddressFactory.createAddress("4 Loop Street", "", "", "")).build();
        repository.save(newCustomer);
        Customer updatedCustomer = repository.findOne(id);
        Assert.assertEquals(updatedCustomer.getAddress().getAddress(), "4 Loop Street");
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Customer customer = repository.findOne(id);
        repository.delete(customer);
        Customer newCustomer = repository.findOne(id);
        Assert.assertNull(newCustomer);
    }

}
