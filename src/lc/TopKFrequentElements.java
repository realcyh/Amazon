package lc;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2)->(count.get(n2)-count.get(n1)));

        for (int n: count.keySet()) {
            heap.add(n);
        }

        List<Integer> res = new LinkedList<Integer>();
        for (int i=0; i<k; i++) {
            res.add(heap.poll());
        }



        // top k largest elements
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);


        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] nums = {1,2,5,6,9,1,2,2};
        int k = 1;
        List<Integer> res = t.topKFrequent(nums, k);
        System.out.println(res);


    }
}
