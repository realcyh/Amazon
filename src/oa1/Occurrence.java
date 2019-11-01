package oa1;

public class Occurrence {
    public static int countOccurrence(int arr[], int value) {
        int i = 0, count = 0, len = arr.length;
        while (i<len){
            if (arr[i] == value) {
                count++;
            }
            i++; //
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4};
        System.out.println(countOccurrence(arr, 2));
    }
}
