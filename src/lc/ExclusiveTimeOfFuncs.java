package lc;

import java.util.*;

public class ExclusiveTimeOfFuncs {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i=1;
        int time = Integer.parseInt(s[2]);
        while (i<logs.size()) {
            s = logs.get(i).split(":");
            i++;
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(s[2]) - time;
                }
                time = Integer.parseInt(s[2]);
                stack.push(Integer.parseInt(s[0]));
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - time + 1;
                time = Integer.parseInt(s[2]) + 1;
                stack.pop();
            }
        }
        return res;
    }
}
