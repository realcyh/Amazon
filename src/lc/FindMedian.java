package lc;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedian {

    PriorityQueue<Integer> small = new PriorityQueue<>((n1,n2)-> (n2-n1));
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        // most important
        if (large.size()<small.size()) {
            large.add(small.poll());
        }
    }

    public double findMedian() {
        if (large.size()>small.size()) {
            return large.peek();
        } else {
            return (large.peek()+small.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        FindMedian f = new FindMedian();
        f.addNum(1);
        f.addNum(2);
        double res = f.findMedian();

        List<Integer> a = new LinkedList<>();
        a.add(3);
        a.add(4);
        List<Integer> b = a;
        b.add(5);
        System.out.println(a);
    }
}
