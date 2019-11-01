package oa2;

import java.util.Arrays;

public class LongestPalindromic {
    // me: expand around center
    public static String palindromic (String s) {
        if (s==null || s.length()<1) return "";
        int n = s.length();
        int max = 0;
        int left = 0, right = 0;

        for (int i=0; i<2*n; i++) {
            int j=(i-1)/2, k=i/2+1;
            int cnt = 1;
            if (i == 0 || i%2 != 0) cnt = 0;
            while (j>=0 && k <n) {
                if ( s.charAt(j) == s.charAt(k)) {
                    cnt += 2;
                    j--;
                    k++;
                } else break;
            }
            if (max<cnt) {
                max = cnt;
                left = j+1;
                right = k-1;
            }
        }
        int j=left, k=right;
        StringBuffer res = new StringBuffer();
        if (left > right) res.append(s.charAt(0));
        for (int i=left; i<=right; i++){
            res.append(s.charAt(i));
        }

        return res.toString();
    }

    // dp
    public static String dpLongestPalindromic(String s) {
        if (s==null || s.length()<1) return "";
        int n = s.length();
        String res = "";

        boolean[][] dp = new boolean[n][n];

        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
                if (dp[i][j] && (res == null || j-i+1>res.length())){
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;

    }

    // lc: expand around center
    public static String longestPalidromic(String s) {
        if (s==null || s.length()<1) return "";
        int start = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end-start) {
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);
    }

    private static int expandCenter(String s, int left, int right) {
        while (left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String s = "abba";

        System.out.println(palindromic(s));

        System.out.println(dpLongestPalindromic(s));

        System.out.println(longestPalidromic(s));




    }
}
