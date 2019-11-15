package lc;

public class NumofIslands {
    private int m, n;
    public int numIslands(char[][] grid) {
        int cnt = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    dfsMark(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfsMark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfsMark(grid, i-1, j);
        dfsMark(grid, i+1, j);
        dfsMark(grid, i, j-1);
        dfsMark(grid, i, j+1);
    }

    public static void main(String[] args) {
        NumofIslands ni = new NumofIslands();
        char[][] grid = {{'1','1','0'}, {'0','0','0'}, {'1','1','1'}};
        int res = ni.numIslands(grid);
        System.out.println(res);

    }
}
