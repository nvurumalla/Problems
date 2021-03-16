package strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 Given an array of intervals where intervals[i] = [start, end],
 merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 *Input:* intervals = [[1,3],[8,10],[2,6],[15,18]]
 *Output:* [[1,6],[8,10],[15,18]]
 *Explanation:* Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

 *Input:* intervals = [[1,4],[4,5]]
 *Output:* [[1,5]]
 *Explanation:* Intervals [1,4] and [4,5] are considered overlapping.

 *Constraints:*

 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 **/

public class MergeIntervals {

    private static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int getStart() {
            return this.start;
        }
        public int getEnd() {
            return this.end;
        }

        public void setStart(int start) {
            this.start = start;
        }
        public void setEnd(int end) {
            this.end = end;
        }

    }

    public static Interval[] merge(Interval[] intervals) {
        // TODO: sort
        // Arrays.sort(intervals);
        //[[1,3],[2,6],[5,10],[15,18]]
        //[[1,9],[2,4],[4,7],[6,8]]
        // mi = 1,3  1,6  1,10

        List<Interval> mergedIntervals = new ArrayList<>();
        int counter = 0;
        for (Interval interval : intervals) {

            if (counter > 0 && (interval.start >= mergedIntervals.get(counter-1).getStart() && interval.start <= mergedIntervals.get(counter-1).getEnd())) {
                if (interval.end > mergedIntervals.get(counter-1).getEnd()) {
                    mergedIntervals.get(counter-1).setEnd(interval.end);
                }

            } else {
                mergedIntervals.add(interval);
                counter++;
            }

        }
        return mergedIntervals.toArray(new Interval[0]);
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[8];

        intervals[0] = new Interval(0,1);
        intervals[1] = new Interval(0,2);
        intervals[2] = new Interval(0,3);
        intervals[3] = new Interval(1,9);
        intervals[4] = new Interval(2,5);
        intervals[5] = new Interval(10,11);
        intervals[6] = new Interval(12,20);
        intervals[7] = new Interval(19,20);

        Interval[] mergedIntervals = merge(intervals);
        for(Interval in : mergedIntervals) {
            System.out.println("["+in.getStart()+", "+in.getEnd()+"]");
        }
    }
}

