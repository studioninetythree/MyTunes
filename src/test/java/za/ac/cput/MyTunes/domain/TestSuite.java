package za.ac.cput.MyTunes.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddressTest.class,
        ContactTest.class,
        CustomerTest.class,
        NameTest.class,
        OrderAlbumTest.class,
        OrdersTest.class,
        AlbumPriceTest.class,
        AlbumTest.class
})
public class TestSuite {
}
