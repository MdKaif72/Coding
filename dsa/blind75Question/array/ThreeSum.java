package dsa.blind75Question.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
LC 15
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j !=
k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        return threeSumBySorting(nums);


    }

    public static List<List<Integer>> threeSumBySorting(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    j++;//this will increase the value of sum
                else if (sum > 0)
                    k--;//this will decrease the value of sum
                else {

                    List<Integer> ans = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    result.add(ans);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])//Increase the j pointer until we find unique element
                        j++;
                    while (j < k && nums[k] == nums[k + 1])//Decrease the k pointer until we find unique element
                        k--;


                }

            }
        }

        return result;


    }

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> ans = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        result.add(ans);
                    }
                }
            }
        }
        return result;


    }


}
