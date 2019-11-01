package oa1;

public class SortArray {
    public static int[] reverseArray( int arr[]) {
        int i, temp, originalLen = arr.length;
        int len = originalLen;
        for (i=0; i<originalLen/2; i++) {
            temp = arr[len-1];
            arr[len-1] = arr[i];
            arr[i] = temp;
            len -= 1; //
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,6};
        int[] res = reverseArray(arr);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
