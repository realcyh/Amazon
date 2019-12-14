package lc;

import java.util.*;

public class StringHash {
    Map<String, Integer> map = new HashMap<>();
    String past;

    public void store(String s, int time) {
        map.put(s, time);
    }

    public int lookup(String s) {
        past = s;
        return map.get(s);
    }

    public String recent() {
        return past;
    }

    public void print() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>> () {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getKey());
        }
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "bb";
        String s3 = "cc";
        StringHash s = new StringHash();
        s.store(s1, 1);
        s.store(s2, 2);
        s.store(s3, 3);
        int t1 = s.lookup(s1);
        System.out.println(t1);
        System.out.println(s.recent());
        int t2 = s.lookup(s2);
        System.out.println(t2);
        System.out.println(s.recent());
        s.print();

    }
}
