package lc;

import java.util.*;

public class InsertDeleteGetRandom {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int position = map.get(val);
        if (position<list.size()-1) {
            int last = list.get(list.size()-1);
            map.put(last, position);
            list.set(position, last);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get( rand.nextInt(list.size()));

    }
}
