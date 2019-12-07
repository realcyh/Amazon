package lc;

import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> l = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(l, temp, s, 0);
        return l;
    }

    private void backtrack(List<List<String>> list, List<String> temp, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i=start; i<s.length(); i++) {
                if (isPalindromic(s, start, i)) {
                    temp.add(s.substring(start, i+1));
                    backtrack(list, temp, s, i+1);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

    private boolean isPalindromic (String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
