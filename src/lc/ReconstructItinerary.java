package lc;

import java.util.*;

public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> map;
    List<String> res;

    // recursive
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

    // iterative
    public List<String> findItinerary2(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (List<String> ticket: tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);
            if (!map.containsKey(departure)) map.put(departure, new PriorityQueue<String>());
            map.get(departure).add(arrival);
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
        }

        return res;
    }

}
