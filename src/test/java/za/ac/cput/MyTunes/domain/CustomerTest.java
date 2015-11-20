package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.AddressFactory;
import za.ac.cput.MyTunes.factories.ContactFactory;
import za.ac.cput.MyTunes.factories.CustomerFactory;
import za.ac.cput.MyTunes.factories.NameFactory;

public class CustomerTest {

    @Test
    public void testCreate() {
        Customer customer = CustomerFactory.createCustomer(NameFactory.createName("Nadine", "Chleo", "Smith"), "Female", "2015-10-28", ContactFactory.createContact("0215632526", "0841111111"), AddressFactory.createAddress("452 Sasol Street", "", "", ""), null);
        Assert.assertEquals(customer.getName().getFirstName(), "Nadine");
        Assert.assertEquals(customer.getContact().getHomePhoneNumber(), "0215632526");
    }

    @Test
    public void testUpdate() {
        Customer customer = CustomerFactory.createCustomer(NameFactory.createName("Nadine", "Chleo", "Smith"), "Female", "2015-10-28", ContactFactory.createContact("0215632526", "0841111111"), AddressFactory.createAddress("452 Sasol Street", "", "", ""), null);
        Customer customerCopy = new Customer.Builder(customer.getName()).copy(customer).address(AddressFactory.createAddress("60 Black Street", "", "", "")).build();
        Assert.assertEquals(customer.getName().getFirstName(), "Nadine");
        Assert.assertEquals(customerCopy.getAddress().getAddress(), "60 Black Street");
    }

}
