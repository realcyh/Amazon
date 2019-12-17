package lc;

public class MaximalRectangle {
    int max;
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        max = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, 1);
                    find(matrix, i, j, 1, 1);
                }
            }
        }
        return max;
    }

    public void find(char[][] matrix, int i, int j, int w, int h) {
        // right
        if (j+w<matrix[0].length) {
            for (int k=0; k<h; k++) {
                if (matrix[i+k][j+w] == '0') break;
                if (k == h-1) {
                    max = Math.max(max, h*(w+1));
                    find(matrix, i, j, w+1, h);
                }
            }
        }
        // down
        if (i+h<matrix.length) {
            for (int k=0; k<w; k++) {
                if (matrix[i+h][j+k] == '0') break;
                if (k == w-1) {
                    max = Math.max(max, (h+1)*w);
                    find(matrix, i, j, w, h+1);
                }
            }
        }
    }
}
