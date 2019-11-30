package lc;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumToK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start<nums.length; start++) {
            int sum = 0;
            for (int end = start; end<nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // hash method -- weird but fast
    public int subarraySumHash(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
