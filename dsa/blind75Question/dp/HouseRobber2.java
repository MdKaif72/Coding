package dsa.blind75Question.dp;

/*
LC 213
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed
. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
can rob tonight without alerting the police.



Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3

 */

import java.util.Arrays;

public class HouseRobber2 {

    public int rob(int[] nums) {

        if (nums.length < 2)
            return nums[0];

        int[] skipFirstHouse = new int[nums.length - 1];
        int[] skipLastHouse = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i + 1];
        }

        return Math.max(robHelper(skipFirstHouse), robHelper(skipLastHouse));

    }


    public static int robHelper(int[] nums) {

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return helper(nums, 0, memo);

    }

    // will give TLE
    private static int helper(int[] nums, int indx, int[] memo) {

        if (indx >= nums.length)
            return 0;

        if (memo[indx] != -1)
            return memo[indx];

        int robbed = nums[indx] + helper(nums, indx + 2, memo);
        int notRobbed = helper(nums, indx + 1, memo);

        memo[indx] = Math.max(robbed, notRobbed);

        return memo[indx];

    }

}
