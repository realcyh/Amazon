package lc;

import java.util.*;

public class LetterCombinationOfPhoneNum {
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return res;
    }

    public void backtrack (String combination, String next) {
        if (next.length() == 0) {
            res.add(combination);
        } else {
            String digit = next.substring(0,1);
            String letters = map.get(digit);
            for (int i=0; i<letters.length(); i++) {
                String letter = letters.substring(i, i+1);
                backtrack(combination + letter, next.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        String digits = "4";
        LetterCombinationOfPhoneNum l = new LetterCombinationOfPhoneNum();
        List<String> res = l.letterCombinations(digits);
        System.out.println(res);
    }
}
