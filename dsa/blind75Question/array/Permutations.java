package dsa.blind75Question.array;

import java.util.ArrayList;
import java.util.List;

/*
LC 46
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backTrack(int[] arr, List<Integer> combination, List<List<Integer>> ans) {


        if (combination.size() == arr.length ) {
            ans.add(new ArrayList<>(combination));
            return;

        }
        for (int num : arr) {
            if (combination.contains(num))
                continue;

            combination.add(num);

            backTrack(arr, combination, ans);

            combination.remove(combination.size() - 1);
        }


    }

}
