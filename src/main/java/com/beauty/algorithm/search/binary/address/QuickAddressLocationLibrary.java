package com.beauty.algorithm.search.binary.address;

import java.util.Collections;
import java.util.Comparator;

public class QuickAddressLocationLibrary extends AddressLocationLibrary {

    /**
     * 使用二分查找，查询ip地址的归属地
     * 时间复杂度O(logn)
     * @param ipAddress
     * @return
     */
    @Override
    public String search(String ipAddress) {
        int ipValue = IPv4IntTransformer.ip2Integer(ipAddress);
        Collections.sort(locations, Comparator.comparing(IntegerAddressLocation::getStartIpAddress));
        int index = lastGreatThan(ipValue);
        if (index == -1) return null;

        IntegerAddressLocation location = locations.get(index);
        return location.contains(ipValue) ? location.getLocation() : null;
    }

    private int lastGreatThan(int ipValue) {
        int low = 0;
        int high = locations.size() - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (ipValue >= locations.get(mid).getStartIpAddress()) {
                if (mid == locations.size() - 1 || ipValue < locations.get(mid+1).getStartIpAddress()) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
