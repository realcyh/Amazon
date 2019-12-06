package lc;

import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder num = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                num.append(c);
            } else if (c == '[') {
                stack.push(num);
                num = new StringBuilder();
                stack.push(cur);
                cur = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = stack.pop();
                int k = Integer.valueOf(stack.pop().toString());
                for (int i = k; i>0; i-- ) {
                    cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }
        return cur.toString();

    }

    public static void main(String[] args) {
        String s = "3[a2[d]]2[bc]";
        DecodeString d = new DecodeString();
        String a = d.decodeString(s);
        System.out.println(a);
    }
}
