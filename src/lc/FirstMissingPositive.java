package lc;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > ans) {
                return ans;
            } else if (nums[i] == ans) {
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {12,3,4,6,1};
        Arrays.sort(nums);
        System.out.println(nums[4]);
    }
}
