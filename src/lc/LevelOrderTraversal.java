package lc;

import java.util.*;

public class LevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    // bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size()>0) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<n; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(list);
        }
        return res;
    }

    // dfs
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, 0);
        return res;

    }

    public void dfs(List<List<Integer>> res, TreeNode node, int depth) {
        if (node == null) return;
        if (depth >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(node.val);
        dfs(res, node.left, depth+1);
        dfs(res, node.right, depth+1);
    }
}
