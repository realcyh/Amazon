package lc;

import java.util.*;

public class VerticalOrderTraverseBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs(list, root, 0, 0);
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] l1, int[] l2) {
                if (l1[0] != l2[0]) {
                    return l1[0]-l2[0];
                } else if (l1[1] != l2[1]) {
                    return l1[1]-l2[1];
                } else return l1[2]-l2[2];
            }
        });
        List<List<Integer>> res = new ArrayList();
        List<Integer> tmp = new ArrayList();
        tmp.add(list.get(0)[2]);
        int pos = list.get(0)[0];

        for (int i=1; i<list.size(); i++) {
            if (list.get(i)[0] == pos) {
                tmp.add(list.get(i)[2]);
            } else {
                res.add(tmp);
                tmp = new ArrayList();
                tmp.add(list.get(i)[2]);
                pos = list.get(i)[0];
            }
        }
        res.add(tmp);
        return res;
    }

    public void dfs(List<int[]> list, TreeNode node, int x, int y) {
        if (node != null) {
            list.add(new int[]{x, y, node.val});
            dfs(list, node.left, x-1, y+1);
            dfs(list, node.right, x+1, y+1);
        }
    }
}
