package oa1;

public class ArrayOperation {
    public static int[] replaceValues(int arr[]) {
        int len = arr.length;
        int i;
        if (len%2 == 0) {
            for (i = 0; i < len; i++) {  //
                arr[i] = 0;
            }
        } else {
            for (i=0; i < len; i++) {  //
                arr[i] = 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] res = replaceValues(arr);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
