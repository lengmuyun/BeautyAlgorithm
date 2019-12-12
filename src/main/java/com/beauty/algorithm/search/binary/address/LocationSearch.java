package com.beauty.algorithm.search.binary.address;

public interface LocationSearch {

    /**
     * 根据ip地址查找归属地
     * @param ipAddress ip地址 0.0.0.0
     * @return
     */
    String search(String ipAddress);

}
