package dsa.blind75Question.dp;

/*
LC 198
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


 */

import java.util.Arrays;

public class HouseRobber {

    public static int rob(int[] nums) {

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
