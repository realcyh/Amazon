package sort;

import java.util.*;

public class Sort {
    public void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length -i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public void selectionSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int minIdx = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    public void insertionSort(int[] arr) {
        for (int i=1; i<arr.length-1; i++) {
            int key = arr[i];
            for (int j=i-1; j>=0; j--) {
                if (arr[j] > key) {
                    arr[j+1] = arr[j];
                    arr[j] = key;
                }
            }
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left<right) {
            int middle = (left+right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            merge(arr, left, middle, right);
        }
    }

    public void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle-left+1;
        int n2 = right-middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i=0; i<n1; i++) {
            L[i] = arr[left+i];
        }
        for (int i=0; i<n2; i++) {
            R[i] = arr[middle+i+1];
        }
        int i=0;
        int j=0;
        int k=left;

        while (i<n1 && j<n2) {
            if (L[i]<R[j]) {
                arr[k] = L[i];
                k++; i++;
            } else {
                arr[k] = R[j];
                k++; j++;
            }
        }
        while (i<n1) {
            arr[k] = L[i];
            i++; k++;
        }
        while (j<n2) {
            arr[k] = R[j];
            j++; k++;
        }
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left<right) {
            int pi = partition(arr, left, right);
            quickSort(arr, left, pi-1);
            quickSort(arr, pi+1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j=left; j<right; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[j];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        arr[right] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i=n/2; i>=0; i--) {
            heapify(arr, n, i);
        }
        for (int i=n-1; i>=0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i, 0);
        }

    }

    // max heap
    public void heapify(int[] arr, int n, int root) {
        int maxIdx = root;
        int left = root*2+1;
        int right = root*2+2;

        if (left < n && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < n && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != root) {
            int tmp = arr[root];
            arr[root] = arr[maxIdx];
            arr[maxIdx] = tmp;
            heapify(arr, n, maxIdx);
        }
    }

    public static void main(String[] args) {
        Sort s = new Sort();
        int[] arr = {2,3,1,6,4,8};
        s.heapSort(arr);
        for (int a: arr) {
            System.out.println(a);
        }

    }
}
