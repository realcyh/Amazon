package lc;

import java.util.*;

public class BinaryTreeMaxPathSum {

    // not completely understand

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    private int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        pathDown(root);
        return maxValue;
    }

    public int pathDown(TreeNode start) {
        if (start == null) return 0;
        int left = Math.max(0, pathDown(start.left));
        int right = Math.max(0, pathDown(start.right));
        maxValue = Math.max(maxValue, left+right+start.val);
        return Math.max(left, right) + start.val;
    }

}
