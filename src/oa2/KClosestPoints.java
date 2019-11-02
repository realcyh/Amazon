package oa2;

import java.util.Arrays;

public class KClosestPoints {
    public static int[][] kClosest(int[][] arr, int k) {
        if (arr==null || arr[0].length<1) return null; // null

        int[][] res = new int[k][arr[0].length];
        int[] dist = new int[arr.length]; // store square result
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=0; j<arr[0].length; j++) {
                sum += Math.pow(arr[i][j], 2);
            }
            dist[i] = sum;
        }
        int[] temp = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            temp[i] = dist[i];
        }
        Arrays.sort(temp);
        int d = temp[k-1];
        int m=0;
        for (int i=0; i<arr.length; i++) {
            int n=0;
            if (dist[i]<=d) {
                res[m++] = arr[i];
//                for (int j=0; j<arr[0].length; j++) {
//                    res[m][n] = arr[i][j];
//                    n++;
//                }
//                m++;
            }
        }
        return res;

    }

    //divide and conquer a.k.a. select sort
    public static int[][] kClosestDv(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    private static int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }
    private static int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }



    public static void main(String[] args) {
        int[][] arr = {{1,2},{2,3},{1,3}};

        int k = 2;
        int[][] res= kClosest(arr, k);
        int[][] res2 = kClosestDv(arr, k);

        System.out.println(res[0][0]+" "+res[0][1]+" "+res[1][0]+" "+res[1][1]);
        System.out.println(res2[0][0]+" "+res2[0][1]+" "+res2[1][0]+" "+res2[1][1]);
    }

}
