package lc;

import java.util.*;

public class NumofIslands {

    // dfs
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


    // bfs
    public int numberOfIslansBFS(char[][] grid) {
        if (grid.length == 0) return 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[]{i,j});
                    while (!queue.isEmpty()) {
                        int curr[] = queue.poll();
                        for (int[] dir: dirs) {
                            int x = curr[0] + dir[0];
                            int y = curr[1] + dir[1];
                            if (x<0 || y< 0 || x>=grid.length || y>=grid[0].length || grid[x][y] == '0') continue;
                            grid[x][y] = '0';
                            queue.offer(new int[] {x, y});
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        NumofIslands ni = new NumofIslands();
        char[][] grid = {{'1','1','0'}, {'0','0','0'}, {'1','1','1'}};
        int res = ni.numIslands(grid);
        System.out.println(res);
        grid = new char[][]{{'1','1','0'}, {'0','0','0'}, {'1','1','1'}};
        int res2 = ni.numberOfIslansBFS(grid);
        System.out.println(res2);

    }
}
