package com.beauty.algorithm.search.binary.address;

import static com.beauty.algorithm.search.binary.address.IPv4IntTransformer.ip2Integer;

public class AddressLocation {

    private String startIpAddress;
    private String endIpAddress;
    private String location;

    public AddressLocation(String startIpAddress, String endIpAddress, String location) {
        this.startIpAddress = startIpAddress;
        this.endIpAddress = endIpAddress;
        this.location = location;
    }

    public String getStartIpAddress() {
        return startIpAddress;
    }

    public String getEndIpAddress() {
        return endIpAddress;
    }

    public String getLocation() {
        return location;
    }

    public IntegerAddressLocation toIntegerAddressLocation() {
        return new IntegerAddressLocation(ip2Integer(startIpAddress), ip2Integer(endIpAddress), location);
    }

}
