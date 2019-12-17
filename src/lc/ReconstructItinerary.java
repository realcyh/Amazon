package lc;

import java.util.*;

public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> map;
    List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        res = new ArrayList<>();

        for (List<String> t: tickets) {
            String depart = t.get(0);
            String arriv = t.get(1);
            if (map.get(depart) == null) map.put(depart, new PriorityQueue<String>());
            map.get(depart).add(arriv);
        }

        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    public void dfs(String depart) {
        PriorityQueue<String> arrivals = map.get(depart);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        res.add(depart);
    }
}
