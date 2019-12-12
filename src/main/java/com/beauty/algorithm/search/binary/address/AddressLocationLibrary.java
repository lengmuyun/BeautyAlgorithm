package com.beauty.algorithm.search.binary.address;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ip地址库
 */
public class AddressLocationLibrary implements LocationSearch {

    protected List<IntegerAddressLocation> locations = new ArrayList<>();

    public AddressLocationLibrary() {
    }

    public void addAddressLocation(AddressLocation location) {
        locations.add(location.toIntegerAddressLocation());
    }

    /**
     * 根据ip地址库中存储的ip地址，查找ip的归属地
     * 时间复杂度O(n)
     * @param ipAddress
     * @return
     */
    public String search(String ipAddress) {
        int ipValue = IPv4IntTransformer.ip2Integer(ipAddress);
        Optional<IntegerAddressLocation> first = locations.stream().filter(loc -> loc.contains(ipValue)).findFirst();
        return first.isPresent() ? first.get().getLocation() : null;
    }

}
