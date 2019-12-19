package lc;

import java.util.*;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) return;
        int n = matrix.length;
        int l = 0;
        int k = n-1;
        while (l<k) {
            for (int j=0; j<n; j++) {
                int tmp = matrix[l][j];
                matrix[l][j] = matrix[k][j];
                matrix[k][j] = tmp;
            }
            l++; k--;
        }
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
