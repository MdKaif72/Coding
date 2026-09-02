package dsa.blind75Question.array;

/*
LC 209
209. Minimum Size Subarray Sum
Medium
Topics
premium lock icon
Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
 sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n
 log(n)).
 */
public class MinSizeSubarraySum {


    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int minSize = Integer.MAX_VALUE;
        int currSum = 0;

        for (int right = 0; right < nums.length; right++) {
            // Add the current number to the running sum
            currSum += nums[right];

            // Shrink the window from the left as long as `currSum` is greater than or equal to `target`
            while (currSum >= target) {
                // Update the minimum size
                minSize = Math.min(minSize, right - left + 1);
                // Reduce the sum by removing the leftmost element
                currSum -= nums[left];
                // Move the left pointer
                left++;
            }
        }

        // If no valid subarray was found, return 0
        return minSize == Integer.MAX_VALUE ? 0 : minSize;

    }

}
