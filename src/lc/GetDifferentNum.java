package lc;

import java.util.*;

public class GetDifferentNum {
    public int getDiff(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }
        int res = 0;
        while (true) {
            if (set.contains(res)) res++;
            else break;
        }
        return res;
    }

    public int getDiff2(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        for (int i=0; i<arr.length; i++) {
            if (res == arr[i]) res++;
            else break;
        }
        return res;
    }

    public static void main(String[] args) {
        GetDifferentNum g = new GetDifferentNum();
        int[] arr = {1,2,3,6,0,4};
        int res = g.getDiff(arr);
        System.out.println(res);
        int res2 = g.getDiff2(arr);
        System.out.println(res2);
    }
}
