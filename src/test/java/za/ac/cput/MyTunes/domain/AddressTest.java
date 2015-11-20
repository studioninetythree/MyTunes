package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.AddressFactory;

public class AddressTest {

    @Test
    public void testCreate() {
        Address address = AddressFactory.createAddress("40 Spine Road", "New York", "United States of America", "5632");
        Assert.assertEquals(address.getAddress(), "40 Spine Road");
        Assert.assertEquals(address.getCity(), "New York");
        Assert.assertEquals(address.getZipCode(), "5632");
    }

    @Test
    public void testUpdate() {
        Address address = AddressFactory.createAddress("40 Spine Road", "New York", "United States of America", "5632");
        Address addressCopy = new Address.Builder(address.getAddress()).copy(address).city("San Francisco").zipCode("5000").build();
        Assert.assertEquals(addressCopy.getAddress(), "40 Spine Road");
        Assert.assertEquals(addressCopy.getCity(), "San Francisco");
        Assert.assertEquals(addressCopy.getZipCode(), "5000");
    }

}
