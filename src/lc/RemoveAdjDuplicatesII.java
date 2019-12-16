package lc;

import java.util.*;

public class RemoveAdjDuplicatesII {
    // stack
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                count.push(count.peek()+1);
                stack.push(s.charAt(i));
                if (count.peek() == k) {
                    for (int j=0; j<k; j++) {
                        count.pop();
                        stack.pop();
                    }
                }
            } else {
                stack.push(s.charAt(i));
                count.push(1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    // two pointer
    public String removeDuplicates2(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }

    public static void main(String[] args) {
        String s = "caabbcd";
        int k = 2;
        RemoveAdjDuplicatesII r = new RemoveAdjDuplicatesII();
        String res = r.removeDuplicates(s, k);
        System.out.println(res);

        String s1 = "abcc";
        String s2 = "bvff";

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(int i = 128; i < s1.length()+128; i++) {
            if(m1.put(s1.charAt(i-128), i) == m2.put(s2.charAt(i-128), i)) {
                System.out.println( m1.put(s1.charAt(i-128), i) == m2.put(s2.charAt(i-128), i));
            }
        }
    }
}
