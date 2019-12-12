package com.beauty.algorithm.search.binary.address;

/**
 * ip地址查询器
 */
public class AddressLocationQuerier {

    private LocationSearch searcher;

    public AddressLocationQuerier(LocationSearch searcher) {
        this.searcher = searcher;
    }

    public String query(String ipAddress) {
        return searcher.search(ipAddress);
    }

}
