package com.beauty.algorithm.search.binary.address;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LocationSearchTest {

    private List<AddressLocation> locations;

    @Before
    public void initialize() {
        locations = new ArrayList<>();
        locations.add(new AddressLocation("202.102.133.0", "202.102.133.255", "山东东营市"));
        locations.add(new AddressLocation("202.102.135.0", "202.102.136.255", "山东烟台"));
        locations.add(new AddressLocation("202.102.156.34", "202.102.157.255", "山东青岛"));
        locations.add(new AddressLocation("202.102.48.0", "202.102.51.251", "江苏宿迁"));
        locations.add(new AddressLocation("202.102.49.15", "202.102.133.255", "江苏泰州"));
        locations.add(new AddressLocation("202.102.56.0", "202.102.56.255", "江苏连云港"));
    }

    @Test
    public void testSearch() {
        AddressLocationLibrary library = new AddressLocationLibrary();
        locations.forEach(library::addAddressLocation);

        assertEquals("山东东营市", library.search("202.102.133.13"));
        assertNull(library.search("202.102.47.13"));
    }

    @Test
    public void testQuickSearch() {
        AddressLocationLibrary library = new QuickAddressLocationLibrary();
        locations.forEach(library::addAddressLocation);

        assertEquals("山东东营市", library.search("202.102.133.13"));
        assertNull(library.search("202.102.47.13"));
    }

}