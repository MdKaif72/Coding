package dsa.blind75Question.dp;

/*
LC 377
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that
 add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.



Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 */

import java.util.Arrays;

public class CombinationSumIV {

    public static int combinationSum4(int[] nums, int target) {

        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;

        return helper(nums, target, 0, memo);

    }

    private static int helper(int[] nums, int target, int indx, int[] memo) {

        if (target == 0)
            return 1;

        if (target < 0 || indx >= nums.length)
            return 0;

        if (memo[target] != -1)
            return memo[target];

        int take = helper(nums, target - nums[indx], 0, memo);
        int reject = helper(nums, target, indx + 1, memo);

        memo[target] = take + reject;

        return take + reject;

    }


}
