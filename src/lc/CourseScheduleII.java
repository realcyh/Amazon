package lc;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];

        int[] inDegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] res = new int[numCourses];

        for (int[] pair: prerequisites) {
            int cur = pair[0];
            int prev = pair[1];
            inDegree[cur]++;
            if (adj[prev] == null) adj[prev] = new ArrayList<Integer>();
            adj[prev].add(cur);
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }
        int index = 0;
        while (que.size()>0) {
            int i = que.poll();
            res[index++] = i;
            if (adj[i] == null) continue;
            for (int neigh: adj[i]) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    que.add(neigh);
                }
            }
        }
        if (index != numCourses) return new int[0];
        return res;
    }

        // general topology
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> topo = new HashMap<>();
        for (int i=0; i<numCourses; i++) {
            inDegree.put(i, 0);
            topo.put(i, new ArrayList<Integer>());
        }

        for (int[] pair: prerequisites) {
            int curr = pair[0];
            int prev = pair[1];
            // prev->curr
            inDegree.put(curr, inDegree.get(curr)+1);
            topo.get(prev).add(curr);
        }

        int[] res = new int[numCourses];
        int i=0;
        while (!inDegree.isEmpty()) {
            boolean flag = false;
            for (int key: inDegree.keySet()) {
                if (inDegree.get(key) == 0) { // start
                    res[i++] = key;
                    for (int child: topo.get(key)) {
                        inDegree.put(child, inDegree.get(child)-1);
                    }
                    inDegree.remove(key);
                    flag = true;
                    break;
                }
            }
            if (!flag) return new int[0];
        }
        return res;
    }

    // dfs
    public int[] findOrder3(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];
        int[] res = new int[numCourses];
        int[] visit = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];

        for (int[] pair: prerequisites) {
            int cur = pair[0];
            int prev = pair[1];
            if (adj[prev] == null) adj[prev] = new ArrayList<Integer>();
            adj[prev].add(cur);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<numCourses; i++) {
            if (!dfs(adj, i, stack, visit)) return new int[0];
        }
        int i=0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    public boolean dfs(List<Integer>[] adj, int v, Stack<Integer> stack, int[] visit) {
        if (visit[v] == 2) return true; // visited
        if (visit[v] == 1) return false; // visiting
        visit[v] = 1;
        if (adj[v] != null) {
            for (int u: adj[v]) {
                if (!dfs(adj, u, stack, visit)) return false;
            }
        }
        visit[v] = 2;
        stack.push(v);
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] courses= {{1,0}, {2,1}};
        CourseScheduleII c = new CourseScheduleII();
        int[] res = c.findOrder3(n, courses);
        for (int r: res) {
            System.out.println(r);
        }

    }
}
