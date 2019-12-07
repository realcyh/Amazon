package lc;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(l, temp, nums);
        return l;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) list.add(new ArrayList<>(tempList));
        else {
            for (int i=0; i<nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                else {
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,3};
        Permutations p = new Permutations();
        List<List<Integer>> res = p.permute(nums);
        System.out.println(res);
    }

}
