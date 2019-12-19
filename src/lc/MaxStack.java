package lc;

import java.util.*;

public class MaxStack {
    public MaxStack(){

    }
    Stack<Integer> stack = new Stack<>();
    int max = Integer.MIN_VALUE;

    public boolean push(int x) {
        if (x>max) {
            stack.push(max);
            max = x;
        }
        stack.push(x);
        return true;
    }

    public void pop() {
        if (stack.pop() == max) {
            max = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMax() {
        return max;
    }
}
