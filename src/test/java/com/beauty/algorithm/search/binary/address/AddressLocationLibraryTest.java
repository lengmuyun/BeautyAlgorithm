package com.beauty.algorithm.search.binary.address;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressLocationLibraryTest {

    @Test
    public void query() {
        AddressLocationLibrary library = new AddressLocationLibrary();
        library.addAddressLocation(new AddressLocation("202.102.133.0", "202.102.133.255", "山东东营市"));
        library.addAddressLocation(new AddressLocation("202.102.135.0", "202.102.136.255", "山东烟台"));
        library.addAddressLocation(new AddressLocation("202.102.156.34", "202.102.157.255", "山东青岛"));
        library.addAddressLocation(new AddressLocation("202.102.48.0", "202.102.51.251", "江苏宿迁"));
        library.addAddressLocation(new AddressLocation("202.102.49.15", "202.102.133.255", "江苏泰州"));
        library.addAddressLocation(new AddressLocation("202.102.56.0", "202.102.56.255", "江苏连云港"));

        assertEquals("山东东营市", library.search("202.102.133.13"));
    }

    @Test
    public void search() {
        AddressLocationLibrary library = new QuickAddressLocationLibrary();
        library.addAddressLocation(new AddressLocation("202.102.133.0", "202.102.133.255", "山东东营市"));
        library.addAddressLocation(new AddressLocation("202.102.135.0", "202.102.136.255", "山东烟台"));
        library.addAddressLocation(new AddressLocation("202.102.156.34", "202.102.157.255", "山东青岛"));
        library.addAddressLocation(new AddressLocation("202.102.48.0", "202.102.51.251", "江苏宿迁"));
        library.addAddressLocation(new AddressLocation("202.102.49.15", "202.102.133.255", "江苏泰州"));
        library.addAddressLocation(new AddressLocation("202.102.56.0", "202.102.56.255", "江苏连云港"));

        assertEquals("山东东营市", library.search("202.102.133.13"));
    }

}