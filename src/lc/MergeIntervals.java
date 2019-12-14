package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

// incorrect
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<intervals.length; i++) {
            list.add(intervals[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] l: list) {
            if (merged.isEmpty() || merged.getLast()[1] < l[0]) {
                merged.add(l);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], l[1]);
            }
        }
        int[][] res = new int[merged.size()][2];
        for (int i=0; i<res.length; i++) {
            res[i] = merged.pop();
        }
        return res;
    }

    // better
    public int[][] merge2(int[][] intervals) {
        if (intervals.length<=1) return intervals;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> list = new ArrayList<>();
        int[] curr = intervals[0];
        list.add(curr);
        for (int[] inter: intervals) {
            if (curr[1] < inter[0]) {
                list.add(inter);
                curr = inter;
            } else {
                curr[1] = Math.max(curr[1], inter[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] intervels = {{1,3}, {2,6}, {8,10},{15,18}};
        int[][] ret = m.merge(intervels);
        for (int i=0; i<ret.length; i++) {
            System.out.println(ret[i][0]+" "+ret[i][1]);
        }
    }
}
