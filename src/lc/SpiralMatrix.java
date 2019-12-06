package lc;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix.length ==0) return ans;
        helper(matrix, ans);
        return ans;
    }

    private List<Integer> helper(int[][] matrix, List<Integer> ans) {
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length;
        if (n == 0) return ans;

//        if (m == 1 && n == 1) {
//            ans.add(matrix[0][0]);
//            return ans;
//        }
        if (m == 1) {
            for (int i=0; i<n; i++) {
                ans.add(matrix[0][i]);
            }
            return ans;
        }
        if (n == 1) {
            for (int i=0; i<m; i++) {
                ans.add(matrix[i][0]);
            }
            return ans;
        }
        for (int i=0; i<n; i++) {
            ans.add(matrix[0][i]);
        }
        for (int i=1; i<m; i++) {
            ans.add(matrix[i][n-1]);
        }
        for (int i=n-2; i>=0; i--) {
            ans.add(matrix[m-1][i]);
        }
        for (int i=m-2; i>0; i--) {
            ans.add(matrix[i][0]);
        }
        int[][] mat = new int[m-2][n-2];
        for (int i=0; i<m-2; i++) {
            for (int j=0; j<n-2; j++) {
                mat[i][j] = matrix[i+1][j+1];
            }
        }
        helper(mat, ans);
        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
        SpiralMatrix s = new SpiralMatrix();
        List<Integer> l = s.spiralOrder(matrix);
        System.out.println(l);
    }
}
