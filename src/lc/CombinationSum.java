package lc;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(l, temp, candidates, target, 0);
        return l;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain<0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i=start; i<nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain-nums[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1,2,3,4};
        int target = 4;
        CombinationSum c = new CombinationSum();
        List<List<Integer>> res = c.combinationSum(candidates, target);
        System.out.println(res);
    }
}
