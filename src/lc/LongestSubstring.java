package lc;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if ( !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j-i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        String s = "abcdde";
        int res = ls.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
