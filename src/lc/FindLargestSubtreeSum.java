package lc;

import java.util.*;

public class FindLargestSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    int max = Integer.MIN_VALUE;

    public int findLargestSubtreeSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int currSum = root.val + helper(root.left) + helper(root.right);
        max = Math.max(currSum, max);
        return currSum;
    }

    public static void main(String[] args) {
        FindLargestSubtreeSum f = new FindLargestSubtreeSum();
        TreeNode root = f.new TreeNode(2);
        root.left = f.new TreeNode(-7);
        root.left.left = f.new TreeNode(8);
        root.right = f.new TreeNode(10);
        int res = f.findLargestSubtreeSum(root);
        System.out.println(res);
    }
}
