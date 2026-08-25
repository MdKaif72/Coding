package dsa.blind75Question.array;

import java.util.Arrays;

/*
LC 698
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty
subsets whose sums are all equal.



Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false


Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].
 */
public class PartitionToKEqualSubsetSum {

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        boolean[] visited = new boolean[nums.length];
        int sum = 0;
        for (int elem : nums)
            sum += elem;
        if (sum % k != 0)
            return false;
        Arrays.sort(nums);
        return helper(nums, 0, 0, k, 0, sum / k, visited);


    }

    private static boolean helper(int[] nums, int indx, int bucketNumber, int k, int currSum, int requiredSum,
                           boolean[] visited) {

        if (bucketNumber == k )
            return true;
        if (currSum == requiredSum)
            return helper(nums, 0, bucketNumber + 1, k, 0, requiredSum, visited);
        if (indx >= nums.length)
            return false;

        if (currSum > requiredSum)
            return false;

        if (visited[indx])
            return helper(nums, indx + 1, bucketNumber, k, currSum, requiredSum, visited);
        else {

            //pick
            visited[indx] = true;
            boolean pick = helper(nums, indx + 1, bucketNumber, k, currSum + nums[indx], requiredSum, visited);

            //skip
            visited[indx] = false;
            boolean skip = helper(nums, indx + 1, bucketNumber, k, currSum, requiredSum, visited);

            return pick || skip;

        }


    }


}





