package lc;

import java.util.*;

public class SumOfDiagonal {
    public int findSum(int[][] matrix, int[] start) {
        int[] curr = new int[2];
        int sum = matrix[start[0]][start[1]];
        curr[0] = start[0]-1;
        curr[1] = start[1]-1;
        while (curr[0]>=0 && curr[1]>=0 && curr[0] <matrix.length && curr[1]<matrix[0].length) {
            sum+=matrix[curr[0]][curr[1]];
            curr[0]--;
            curr[1]--;
        }
        curr[0] = start[0]+1;
        curr[1] = start[1]-1;
        while (curr[0]>=0 && curr[1]>=0 && curr[0] <matrix.length && curr[1]<matrix[0].length) {
            sum+=matrix[curr[0]][curr[1]];
            curr[0]++;
            curr[1]--;
        }
        curr[0] = start[0]+1;
        curr[1] = start[1]+1;
        while (curr[0]>=0 && curr[1]>=0 && curr[0] <matrix.length && curr[1]<matrix[0].length) {
            sum+=matrix[curr[0]][curr[1]];
            curr[0]++;
            curr[1]++;
        }
        curr[0] = start[0]-1;
        curr[1] = start[1]+1;
        while (curr[0]>=0 && curr[1]>=0 && curr[0] <matrix.length && curr[1]<matrix[0].length) {
            sum+=matrix[curr[0]][curr[1]];
            curr[0]--;
            curr[1]++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix= {{1,2,3}, {2,3,4},{3,4,5}};
        int[] start ={1,0};
        SumOfDiagonal s = new SumOfDiagonal();
        int res = s.findSum(matrix, start);
        System.out.println(res);
    }
}
