package lc;

import java.util.*;

public class SearchRotatedSortedArray {
    public int searchBruteForce(int[] nums, int target) {
        if (nums.length<1) return -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // binary
    public int search2(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int m = nums.length;

        int start = 0;
        int end = 0;
        if (target <= nums[m-1]) {
            start = minIdx;
            end = m-1;
        } else {
            start = 0;
            end = minIdx;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end -  start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    // wrong
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int minIndex = 0;
        while (start<end) {
            minIndex = start + (end - start)/2;
            if (nums[minIndex] > nums[end]) {
                start = minIndex+1;
            } else {
                end = minIndex;
            }
        }
        minIndex = start;

        if (nums[0] > target) {
            start = minIndex;
            end = nums.length-1;
        } else {
            start = 0;
            end = minIndex;
        }

        while (start<=end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4,5,6,7,0,1,2};
        int target = 0;
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        int a = s.search(nums, target);
        System.out.println(a);
    }


}
