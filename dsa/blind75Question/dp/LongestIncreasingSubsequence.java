package dsa.blind75Question.dp;

/*
LC 300
Given an integer array nums, return the length of the longest strictly increasing subsequence.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int memo[] = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (memo[j] + 1 > memo[i])
                        memo[i] = memo[j] + 1;
                }


            }


        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (memo[i] > max)
                max = memo[i];
        }
        return max + 1;
    }

}
