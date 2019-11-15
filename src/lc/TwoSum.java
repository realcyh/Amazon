package lc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++) {
            int res1 = nums[i];
            int res2 = target - res1;
            for (int j=i+1; j<nums.length; j++) {
                if (res2 == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    // hashmap
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res) != i) {
                return new int[] {i, map.get(res)};
            }
        }

        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target = 3;
        int[] res = twoSum(nums, target);
        int[] res2 = twoSumHash(nums, target);
        System.out.println(res[0]+" "+res[1]);
        System.out.println(res2[0]+" "+res2[1]);

    }
}