package lc;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("..");
        set.add(".");
        set.add("");
        for (String dir: path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!set.contains(dir)) stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        for (String dir: stack) {
            sb.append("/"+dir);
        }
        if (sb.length() == 0) return "/";
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
    }
}
