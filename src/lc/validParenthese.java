package lc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParenthese {
    //hashmap + stack
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if ( map.containsKey(c)) {
                char topElem = stack.empty() ? '#' : stack.pop();
                if ( topElem != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.empty();
    }

    // only stack
    public static boolean isValidStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.empty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "([]){}";
        boolean res = isValid(s);
        System.out.println(res);


    }
}
