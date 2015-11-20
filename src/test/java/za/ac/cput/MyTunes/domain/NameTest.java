package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.NameFactory;

public class NameTest {

    @Test
    public void testCreate() {
        Name name = NameFactory.createName("Hinata", "Namakazi", "Hyuuga");
        Assert.assertEquals(name.getFirstName(), "Hinata");
        Assert.assertEquals(name.getLastName(), "Hyuuga");
    }

    @Test
    public void testUpdate() {
        Name name = NameFactory.createName("Hinata", "Namakazi", "Hyuuga");
        Name nameCopy = new Name.Builder(name.getLastName()).copy(name).lastName("Uzumaki").build();
        Assert.assertEquals(nameCopy.getFirstName(), "Hinata");
        Assert.assertEquals(nameCopy.getLastName(), "Uzumaki");
    }

}
