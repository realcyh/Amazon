package lc;

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
        System.out.println(res);
        f.addNum(3);
        res = f.findMedian();
        System.out.println(res);
    }
}
