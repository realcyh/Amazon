package lc;

import java.util.*;

public class CourseSchedule {
    // dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;

        int[] visit = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int[] pair: prerequisites) {
            int cur = pair[0];
            int prev =pair[1];
            if(adj[prev] == null) adj[prev] = new ArrayList<>();
            adj[prev].add(cur);
        }

        for (int i=0; i<numCourses; i++) {
            if (!dfs(adj, i, visit)) return false;
        }
        return true;
    }

    public boolean dfs(List<Integer>[] adj, int v, int[] visit) {
        if (visit[v] == 2) return true; // visited
        if (visit[v] == 1) return false; // visiting
        visit[v] = 1;
        if (adj[v] != null) {
            for (int u: adj[v]) {
                if (!dfs(adj, u, visit)) return false;
            }
        }
        visit[v] = 2;
        return true;
    }

    // bfs
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;

        int[] inDegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int[] pair: prerequisites) {
            int cur = pair[0];
            int prev = pair[1];
            // prev->curr
            inDegree[cur]++;
            if (adj[prev] == null) adj[prev] = new ArrayList<>();
            adj[prev].add(cur);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (queue.size() > 0) {
            int idx = queue.poll();
            count++;
            if (adj[idx] == null) continue;
            for (int neigh: adj[idx]) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) queue.add(neigh);
            }
        }

        if (count == numCourses) return true;
        return false;
    }
}
