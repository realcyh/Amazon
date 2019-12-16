package lc;

import java.util.*;

public class RemoveAdjDuplicates {
    // stack
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i=1; i<S.length(); i++) {
            if (!stack.isEmpty() && S.charAt(i) == stack.peek()) stack.pop();
            else stack.push(S.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    // two pointers
    public String removeDuplicates2(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }
}
