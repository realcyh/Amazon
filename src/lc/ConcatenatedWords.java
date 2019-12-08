package lc;

import java.util.*;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        List<String> res = new LinkedList<>();
        Arrays.sort(words, (s1, s2) -> s1.length()-s2.length());

        for (int i=0; i<words.length; i++) {
            if (isConcat(words[i], set)) {
                res.add(words[i]);
            }
            set.add(words[i]);
        }
        return res;
    }

    private boolean isConcat (String s, Set<String> set) {
        if (set.isEmpty()) return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (!dp[j]) continue;
                if (set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {

    }
}
