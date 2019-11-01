package oa1;

import java.util.HashMap;

public class ArraySort {
    public static int[] sortArray(int arr[]) {
        int i, max, location, j, temp, len = arr.length;
        for (i = 0; i < len; i++) {
            max = arr[i];
            location = i;
            for (j = i; j < len; j++) {
                if (max < arr[j]) {   //
                    max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};
        int[] res = sortArray(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }
    }
}

