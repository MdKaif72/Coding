package dsa.blind75Question.dp;

/*
LC 55
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
 array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it
impossible to reach the last index.
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {

        return canJumpGreedy(nums);
    }

    //Greedy Approach
    public static boolean canJumpGreedy(int[] nums) {

        int finalPosition = nums.length - 1;

        for (int indx = nums.length - 2; indx >= 0; indx--) {

            if (indx + nums[indx] >= finalPosition)
                finalPosition = indx;

        }

        return finalPosition == 0;

    }


    private static boolean helper(int[] nums, int indx) {

        if (indx >= nums.length - 1) {
            return true;
        }

        int currJumpICanTake = nums[indx];
        for (int i = 1; i <= currJumpICanTake; i++) {
            if (helper(nums, indx + i)) {
                return true;      // short-circuit
            }

        }
        return false;


    }

}
