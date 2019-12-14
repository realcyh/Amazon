package lc;

import java.util.*;

public class TrapRainWater {
    public int trap(int[] height) {
        int ans = 0;
        for (int i=0; i<height.length; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j=i; j>=0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            for (int k=i; k<height.length; k++) {
                if (height[k] > maxRight) {
                    maxRight = height[k];
                }
            }
            ans += (Math.min(maxLeft, maxRight) - height[i]);
        }
        return ans;
    }
}
