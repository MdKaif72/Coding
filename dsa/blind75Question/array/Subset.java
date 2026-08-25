package dsa.blind75Question.array;

import java.util.ArrayList;
import java.util.List;

/*
LC 78
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */
public class Subset {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        System.out.println(ans);
        return ans;


    }

    private static void helper(int[] nums, int indx, List<Integer> combination, List<List<Integer>> ans) {

        if (indx > nums.length)
            return;
        if (indx == nums.length) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        combination.add(nums[indx]);
        helper(nums, indx + 1, combination, ans);
        combination.remove(combination.size() - 1);
        helper(nums, indx + 1, combination, ans);


    }

}
