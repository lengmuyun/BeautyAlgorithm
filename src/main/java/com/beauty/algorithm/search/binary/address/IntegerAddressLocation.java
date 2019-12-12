package com.beauty.algorithm.search.binary.address;

public class IntegerAddressLocation {

    private int startIpAddress;
    private int endIpAddress;
    private String location;

    public IntegerAddressLocation(int startIpAddress, int endIpAddress, String location) {
        this.startIpAddress = startIpAddress;
        this.endIpAddress = endIpAddress;
        this.location = location;
    }

    public int getStartIpAddress() {
        return startIpAddress;
    }

    public int getEndIpAddress() {
        return endIpAddress;
    }

    public String getLocation() {
        return location;
    }

    public boolean contains(int ipAddress) {
        return startIpAddress <= ipAddress && ipAddress <= endIpAddress;
    }

}
