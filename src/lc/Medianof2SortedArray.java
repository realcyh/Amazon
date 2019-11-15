package lc;

public class Medianof2SortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1 + l2;
        int[] res = new int[l];
        int j=0, k=0;
        for (int i=0; i<l/2 + 1; i++) {
            if (j<l1) {
                if (k<l2) {
                    if (nums1[j] <nums2[k]) {
                        res[i] = nums1[j];
                        j++;
                    } else {
                        res[i ]= nums2[k];
                        k++;
                    }
                } else {
                    res[i] = nums1[j];
                    j++;
                }
            } else {
                res[i] = nums2[k];
                k++;
            }
        }

        if (l%2 == 0) return (double)(res[l/2] + res[l/2-1])/2.0;
        else return res[l/2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9};
        int[] nums2 = {2,4,6};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println( res );
    }
}
