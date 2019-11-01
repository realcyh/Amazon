package oa2;

import java.util.*;

public class MostCommonWord {
    public static List<String> mostCommonWord(String paragraph, List<String> banned) {
        paragraph += ".";

        List<String> res = new ArrayList<>();

        int resFreq = 0;

        Set<String> bannedSet = new HashSet<>();
        for (String s: banned) {
            bannedSet.add(s.toLowerCase());
        }

        Map<String, Integer> cnt = new HashMap<>();

        StringBuilder word = new StringBuilder();

        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length()>0) {
                String temp = word.toString();
                if (!bannedSet.contains(temp)) {
                    cnt.put(temp, cnt.getOrDefault(temp, 0) +1);
                    if (cnt.get(temp) > resFreq) {
                        resFreq = cnt.get(temp);
                    }
                }
                word = new StringBuilder();
            }
        }
        int i=0;
        for (String key: cnt.keySet()) {
            if (cnt.get(key) == resFreq) {
                res.add(key);
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit flew like";
        List<String> banned = new ArrayList<>();
        banned.add("hit");
        banned.add("LIKE");
        List<String> res = mostCommonWord(s, banned);

        for (String t: res) {
            System.out.println(t);
        }

    }
}
