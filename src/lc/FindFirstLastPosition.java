package lc;

import java.util.*;

public class FindFirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) return res;

        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = (low+high) / 2;
            if (target > nums[mid]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        if (nums[low] != target) return res;
        res[0] = low;
        high = nums.length - 1;

        while (low < high) {
            int mid = (low+high) / 2 + 1;
            if (target < nums[mid]) {
                high = mid-1;
            } else {
                low = mid;
            }
        }
        res[1] = high;
        return res;
    }
}
