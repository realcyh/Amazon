package lc;

import java.util.*;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
//        Arrays.sort(intervals, Comparator.comparing( itv -> itv[0]));
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        if (intervals.length < 1) {
//            return 0;
//        }
//        heap.offer(intervals[0][1]);
//        for (int i=1; i< intervals.length; i++) {
//            if (intervals[i][0] >= heap.peek()) {
//                heap.poll();
//                heap.offer(intervals[i][1]);
//            } else {
//                heap.offer(intervals[i][1]);
//            }
//        }
//        int res = heap.size();
//        return res;

        Arrays.sort(intervals, (itv1, itv2)->itv1[0] - itv2[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
                queue.add(intervals[i][1]);
            } else {
                queue.add(intervals[i][1]);
            }
        }
        return queue.size();

    }

    public static void main(String[] args) {
        int[][] interval= {{1,5},{10,15},{2,9}};
        MeetingRoomII m = new MeetingRoomII();
        int res = m.minMeetingRooms(interval);
        System.out.println(res);
    }



}
