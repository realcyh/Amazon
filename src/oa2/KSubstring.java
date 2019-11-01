package oa2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KSubstring {
    public static List<String> ksub (String s, int k) {
        Set<String> res = new HashSet<>();
        for (int i=0; i<s.length()-k+1; i++) {
            Set<Character> temp = new HashSet<>();
            for (int j=i; j<i+k; j++) {
                temp.add(s.charAt(j));
            }
            if (temp.size() == k) {
                res.add(s.substring(i,i+k));
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String s = "aaaaaaabcadab";
        int k = 2;
        ksub(s,k);
        System.out.println(ksub(s,k));

    }
}
