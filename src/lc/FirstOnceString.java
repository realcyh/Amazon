package lc;

import java.util.*;

public class FirstOnceString {
    public String firstString(String[] s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<s.length; i++) {
            map.put(s[i], map.getOrDefault(s[i], 0) +1);
        }
        for (int i=0; i<s.length; i++) {
            if (map.get(s[i]) == 1) {
                return s[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] s = {"aaa", "bbb", "ccc", "aaa", "ddd"};
        FirstOnceString f = new FirstOnceString();
        String res = f.firstString(s);
        System.out.println(res);
    }
}
