package lc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
