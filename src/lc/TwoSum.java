package lc;

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

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target = 3;
        int[] res = twoSum(nums, target);
        System.out.println(res[0]+" "+res[1]);

    }
}