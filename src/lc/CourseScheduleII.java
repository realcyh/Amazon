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
}
