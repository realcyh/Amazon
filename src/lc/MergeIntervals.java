package lc;

import java.util.ArrayList;
import java.util.List;

// incorrect
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<Integer> res = new ArrayList<Integer>();
        int m = intervals.length;
        if (m == 0) {
            int[][] ret = {};
            return ret;
        }
        res.add(intervals[0][0]);
        res.add(intervals[0][1]);
        int j = 1;

        for (int i=1; i<m; i++) {
            if (intervals[i][0] <= res.get(j)) {
                res.remove(j);
                res.add(intervals[i][1]);
            } else {
                res.add(intervals[i][0]);
                res.add(intervals[i][1]);
                j += 2;
            }
        }
        int n = res.size();
        n /= 2;
        int[][] ret = new int[n][2];
        for (int i=0; i<n; i++) {
            ret[i][0] = res.get(2*i);
            ret[i][1] = res.get(2*i+1);
        }
        return ret;

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
