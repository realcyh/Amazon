package lc;

import java.util.*;

public class PancakeSort {
    public void flip(int[] arr, int k) {
        if (arr == null || arr.length<=1) return;
        int i=0;
        int j=k-1;
        while (i<j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
    }

    public int[] pancakeSort(int[] arr) {
        for (int j=arr.length; j>0; j--) {
            int max = 0;
            for (int i=0; i<j; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    flip(arr, i+1);
                }
            }
            flip(arr, j);
        }
        return arr;
    }

    public static void main(String[] args) {
        PancakeSort p = new PancakeSort();
        int[] arr = {5,3,4,2,1};
        int[] res = p.pancakeSort(arr);
        for (int r: res) {
            System.out.println(r);
        }
    }

}
