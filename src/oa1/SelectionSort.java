package oa1;

public class SelectionSort {
    public static int[] sortArray(int arr[]) {
        int x=0, y=0, n=arr.length;
        for (x=0; x<n; x++) {
            int index_of_min = x;
            for (y=x; y<n; y++) {
                if (arr[index_of_min]>arr[y]) {  //
                    index_of_min = y;
                }
            }
            int temp = arr[x];
            arr[x] = arr[index_of_min];
            arr[index_of_min] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,3,4};
        int[] res = sortArray(arr);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
