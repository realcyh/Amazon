package oa2;

public class PathWithMaxScore {
    // 2-D dp
    public static int dp(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] tmp = new int[m][n];
        tmp[0][0] = Integer.MAX_VALUE;
        for (int i=1; i<n; i++) {
            tmp[0][i] = Math.min(tmp[0][i-1], arr[0][i]);
        }
        for (int j=1; j<m; j++) {
            tmp[j][0] = Math.min(tmp[j-1][0], arr[j][0]);
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if ( i==m-1 && j == n-1) {
                    tmp[i][j] = Math.max(tmp[i-1][j], tmp[i][j-1]);
                }
                else {
                    int score1 = Math.min(tmp[i-1][j], arr[i][j]);
                    int score2 = Math.min(tmp[i][j-1], arr[i][j]);
                    tmp[i][j] = Math.max(score1, score2);
                }
            }

        }
        return tmp[m-1][n-1];
    }

    public static int dpMe(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = Integer.MAX_VALUE;
        for (int i=1; i<m; i++) {
            dp[i][0] = Math.min(dp[i-1][0], arr[i][0]);
        }
        for (int j=1; j<n; j++) {
            dp[0][j] = Math.min(dp[0][j-1], arr[0][j]);
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (i==m-1 && j== n-1) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                } else {
                    int score1 = Math.min(dp[i-1][j], arr[i][j]);
                    int score2 = Math.min(dp[i][j-1], arr[i][j]);
                    dp[i][j] = Math.max(score1, score2);
                }

            }
        }
        return dp[m-1][n-1];
    }

    // 1-D dp
    public static int dpOneD (int[][] arr) {
        int[] res = new int[arr[0].length];
        res[0] = Integer.MAX_VALUE;
        for (int j=1; j<arr[0].length; j++) {
            res[j] = Math.min(res[j-1], arr[0][j]);
        }
        for (int i=1; i<arr.length; i++) {
            res[0] = Math.min(res[0], arr[i][0]);
            for (int j=1; j<arr[i].length; j++) {
                res[j] = (res[j] < arr[i][j] && res[j-1] < arr[i][j]) ? Math.max(res[j], res[j-1]) : arr[i][j];
            }
        }
        return res[res.length-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{5,6}};
        System.out.println(dp(arr));
        System.out.println(dpMe(arr));
        System.out.println(dpOneD(arr));
    }
}
