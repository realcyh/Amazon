package lc;

import java.util.*;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] height = new int[2*buildings.length][2];
        for (int i=0; i<buildings.length; i++) {
            height[2*i][0] = buildings[i][0];
            height[2*i][1] = -buildings[i][2];
            height[2*i+1][0] = buildings[i][1];
            height[2*i+1][1] = buildings[i][2];
        }
        Arrays.sort(height, (h1, h2) -> (h1[0] != h2[0] ? h1[0] - h2[0] : h1[1] - h2[1]));
        Queue<Integer> queue = new PriorityQueue<>((a, b)-> b-a);
        queue.offer(0);
        int prev = 0;
        for (int i=0; i<height.length; i++) {
            if (height[i][1] < 0) {
                queue.offer(-height[i][1]);
            } else {
                queue.remove(height[i][1]);
            }
            int curr = queue.peek();
            if (curr != prev) {
                prev = curr;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(height[i][0]);
                tmp.add(curr);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        SkylineProblem s = new SkylineProblem();
        List<List<Integer>> res = s.getSkyline(buildings);
        System.out.println(res);
    }
}
