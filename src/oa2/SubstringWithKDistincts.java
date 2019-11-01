package oa2;

import java.util.Arrays;

public class SubstringWithKDistincts {
    public static int substringK(String s, int k) {
        int[] cnt = new int[26];
        int res = 0;  // may consider null!
        for (int i=0; i<s.length(); i++) {
            int dist_count = 0;
            Arrays.fill(cnt, 0);

            for (int j=i; j<s.length(); j++) {
                if (cnt[s.charAt(j) - 'a'] == 0) dist_count++;
                cnt[s.charAt(j) - 'a']++;
                if (dist_count == k) res++;
                if (dist_count > k) break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcc";
        int k = 2;
        int m = substringK(s, k);
        System.out.println(m);
    }
}
