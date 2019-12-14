package lc;

import java.util.*;

public class FindSubstring {
    public int findIndex(String s1, String s2) {
        int index = -1;

        for (int j=0; j<s2.length(); j++) {
            int i=0;
            int k=j;
            while (i<s1.length()) {
                if (k>=s2.length() || s1.charAt(i) != s2.charAt(k)) break;
                i++;
                k++;
            }
            if (i == s1.length()) {
                index = j;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "aabcddefgabcd";
        FindSubstring f = new FindSubstring();
        int res = f.findIndex(s1, s2);
        System.out.println(res);
    }
}
