package lc;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: words) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        //     public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        //         if (e2.getValue() != e1.getValue()) return e2.getValue() - e1.getValue();
        //         else return (e1.getKey()).toString().compareTo(e2.getKey());
        //     }
        // });

        Collections.sort(list, (k1, k2) -> k1.getValue() == k2.getValue() ? k1.getKey().toString().compareTo(k2.getKey()) : k2.getValue() - k1.getValue());

        List<String> res = new ArrayList<>();
        for (int i=0; i<k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }
}
