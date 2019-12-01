package lc;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    // not fulfill space complexity
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }
}
