package dsa.blind75Question.dp;

import java.util.Arrays;

/*
LC 45
You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at
index i, you can jump to any index (i + j) where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n
 - 1.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to
 the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */
public class JumpGameII {

    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length - 1] = 0;
        jumpByDP(nums, 0, dp);
        return dp[0];


    }

    private static int jumpByRecursion(int[] nums, int indx) {

        if (indx == nums.length - 1)
            return 0;
        int jump = nums.length;
        for (int i = 1; i <= nums[indx]; i++) {
            if (i + indx <= nums.length - 1) {
                int jumpReq = 1 + jumpByRecursion(nums, indx + i);
                jump = Math.min(jump, jumpReq);
            }
        }
        return jump;

    }


    private static int jumpByDP(int[] nums, int indx, int[] dp) {

        if (indx == nums.length - 1)
            return 0;
        int jump = nums.length;
        for (int i = 1; i <= nums[indx]; i++) {
            if (i + indx <= nums.length - 1) {
                if (dp[i + indx] != -1) {
                    jump = Math.min(jump, 1 + dp[i + indx]);
                    continue;
                }
                int jumpReq = 1 + jumpByDP(nums, indx + i, dp);
                jump = Math.min(jump, jumpReq);
            }
        }
        dp[indx] = jump;
        return jump;

    }

    public int jumpByTabularization(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // dp[i] will hold the minimum number of jumps needed to go from i to n-1
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;  // at the last index we need zero jumps

        // Fill the table from right to left
        for (int i = n - 2; i >= 0; i--) {
            int maxJump = nums[i];
            for (int step = 1; step <= maxJump && i + step < n; step++) {
                if (dp[i + step] != Integer.MAX_VALUE) { // reachable
                    dp[i] = Math.min(dp[i], 1 + dp[i + step]);
                }
            }
        }

        return dp[0];
    }

    public int jumpByGreedy(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }


}
