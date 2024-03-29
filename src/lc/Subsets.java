package lc;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(l, temp, nums, 0);
        return l;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i=start; i<nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
