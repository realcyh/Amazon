package oa2;

import java.util.*;

public class PairWithSum {
    // hash-map
    public static List<Integer> findPair(List<Integer> nums, int target) {
        //target -= 30;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int largest = 0;
        for (int i=0; i<nums.size(); i++) {
            int complement = target-nums.get(i);
            if ((nums.get(i) > largest || complement > largest) && map.containsKey(complement)){  // > or >=
                res.add(map.get(complement));
                res.add(i);
                largest = Math.max(nums.get(i), complement);
            }
            map.put(nums.get(i), i);
        }
        return res;

    }


    public static int[] twoSum (int[] arr, int target) {
        int[] res = new int[2];
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    if (Math.max(arr[i], arr[j]) > Math.max(arr[res[0]], arr[res[1]])) {
                        res[0] = i;
                        res[1] = j;
                    }

                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] res = twoSum(arr, 8);
        for (int e: res) {
            System.out.println(e);
        }

        List<Integer> num = Arrays.asList(1,2,3,4,5,4,3);
        int target = 3;
        System.out.println(findPair(num, target));


    }
}
