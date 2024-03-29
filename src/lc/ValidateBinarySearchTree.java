package lc;

import java.util.*;

public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        List<Integer> res = inOrderTraversal(list, root);
        for (int i=1; i<res.size(); i++) {
            if (res.get(i-1) > res.get(i)) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> inOrderTraversal(List<Integer> l, TreeNode start) {
        if (start == null) return l;
        if (start.left == null && start.right == null) {
            l.add(start.val);
            return l;
        }
        if (start.left != null) {
            inOrderTraversal(l, start.left);
        }
        l.add(start.val);
        if (start.right != null) {
            inOrderTraversal(l, start.right);
        }
        return l;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        TreeNode t = v.new TreeNode(2);
        System.out.println(t.val);
        tree tt = new tree(3);
        System.out.println(tt.val);
        tree tre = new tree(4);
        System.out.println(tre.val);
        tree.treeinner ttt = tre.new treeinner(5);
        System.out.println(ttt.val);
    }
}

class tree {
    int val;
    tree next;
    tree(int x) {
        val = x;
    }

    public class treeinner {
        int val;
        treeinner(int x) {
            val = x;
        }
    }
}
