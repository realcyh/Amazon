package lc;

import java.util.*;

public class CoinChange {
    // iterative bottom up
    public int coinChange(int[] coins, int amount) {
        //if (coins.length == 0 || amount<=0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (i-coins[j]>=0) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }

        }
        if (dp[amount] > amount) return -1;
        else return dp[amount];
    }

    // recursive top down
    public int coinChange2(int[] coins, int amount) {
        if (amount<1) return 0;
        int[] count = new int[amount+1];
        count[0] = 0;
        return helper(coins, amount, count);
    }

    public int helper(int[] coins, int remain, int[] count) {
        if (remain<0) return -1;
        if (remain == 0) return 0;
        if (count[remain] != 0) return count[remain];
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            int res = helper(coins, remain-coin, count);
            if (res>=0 && res<min) {
                min = 1+res;
            }
        }
        count[remain] = (min== Integer.MAX_VALUE) ? -1: min;
        return count[remain];
    }
}
