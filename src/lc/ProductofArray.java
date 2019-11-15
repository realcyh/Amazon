package lc;

public class ProductofArray {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            res[i] = 1;
            for (int j=0; j<nums.length; j++) {
                if (i == j) ;
                else {
                    res[i] *= nums[j];
                }
            }
        }
        return res;
    }

    // left & right array
    public int[] productExceptSelfLR(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        int[] res = new int[n];
        L[0] = 1;
        R[n-1] = 1;
        for (int i=1; i<n; i++) {
            L[i] = L[i-1] * nums[i-1];
            R[n-1-i] = R[n-i] * nums[n-i];
        }
        for (int i=0; i<n; i++) {
            res[i] = L[i]*R[i];
        }
        return res;

    }



    public static void main(String[] args) {
        ProductofArray pa = new ProductofArray();
        int[] nums = {1,2,3,4};
        int[] res = pa.productExceptSelf(nums);
        int[] res2 = pa.productExceptSelfLR(nums);
        for (int i: res2) {
            System.out.println(i);
        }
    }
}
