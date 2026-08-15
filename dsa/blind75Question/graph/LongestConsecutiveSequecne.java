package dsa.blind75Question.graph;

import java.util.HashMap;
import java.util.Map;

/*
LC 128
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
 */
public class LongestConsecutiveSequecne {

    public int longestConsecutive(int[] nums) {

        int maxLength = 0;
        Map<Integer, Boolean> exploredMap = new HashMap<>();
        for (int num : nums)
            exploredMap.put(num, Boolean.FALSE);

        for (int num : nums) {

            int currLength = 1;

            int nextNum = num + 1;
            while (exploredMap.containsKey(nextNum) && !exploredMap.get(nextNum)) {
                currLength++;
                exploredMap.put(nextNum, Boolean.TRUE);
                nextNum++;
            }
            //check in reverse direction
            int prevNum = num - 1;
            while (exploredMap.containsKey(prevNum) && !exploredMap.get(prevNum)) {
                currLength++;
                exploredMap.put(prevNum, Boolean.TRUE);
                prevNum--;
            }
            maxLength = Math.max(maxLength, currLength);

        }
        return maxLength;
    }

}
