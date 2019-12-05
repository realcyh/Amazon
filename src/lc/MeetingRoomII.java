package lc;

import java.util.*;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing( itv -> itv[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        if (intervals.length < 1) {
            return 0;
        }
        heap.offer(intervals[0][1]);
        for (int i=1; i< intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.poll();
                heap.offer(intervals[i][1]);
            } else {
                heap.offer(intervals[i][1]);
            }
        }
        int res = heap.size();
        return res;

    }

}
