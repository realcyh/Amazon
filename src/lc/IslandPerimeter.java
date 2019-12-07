package lc;

import java.util.*;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int num = 0;
        int neighbor = 0;
        if (grid.length == 0) return 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    num++;
                    if (i>0 && grid[i-1][j] == 1) neighbor++;
                    if (i<grid.length-1 && grid[i+1][j] == 1) neighbor++;
                    if (j>0 && grid[i][j-1] == 1) neighbor++;
                    if (j<grid[0].length-1 && grid[i][j+1] == 1) neighbor++;
                }
            }
        }
        return num*4 - neighbor;

    }
}
