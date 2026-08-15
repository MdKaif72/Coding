package dsa.blind75Question.interval;

import java.util.Arrays;
import java.util.Comparator;

/*
LC 435
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you
 need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.



Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;

        int previousInterval = 0;

        for (int i = 1; i < intervals.length; i++) {

            //If the start time of the next interval is greater than or equal to the end time of the current interval
            // , then we can keep it
            if (intervals[i][0] >= intervals[previousInterval][1]) {
                previousInterval = i;
                count++;
            }

        }

        return intervals.length - count;


    }

}
