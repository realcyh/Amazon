package lc;

import java.util.*;

public class LongestDuplicateSubstring {
    public String longestDupSubstring(String S) {
        for (int k= S.length()-1; k>0; k--) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i<=S.length()-k; i++) {
                String tmp = S.substring(i, k+i);
                map.put(tmp, map.getOrDefault(tmp, 0)+1);
                if (map.get(tmp) >= 2) return tmp;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "banana";
        LongestDuplicateSubstring l = new LongestDuplicateSubstring();
        String res = l.longestDupSubstring(s);
        System.out.println(res);
    }
}
