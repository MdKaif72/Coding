package dsa.blind75Question.array;

/*
LC 33
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        return modifiedBinarySearch(nums, target, 0, nums.length - 1);


    }

    private int modifiedBinarySearch(int[] arr, int target, int left, int right) {

        //Not Found
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;

        //If left half is sorted
        if (arr[mid] >= arr[left]) {

            //If key is in left half
            if (arr[left] <= target && target <= arr[mid])
                return modifiedBinarySearch(arr, target, left, mid - 1);
            else
                return modifiedBinarySearch(arr, target, mid + 1, right);

        } else {

            //If right half is sorted

            //If key is in right half
            if (arr[mid] <= target && target <= arr[right])
                return modifiedBinarySearch(arr, target, mid + 1, right);
            else
                return modifiedBinarySearch(arr, target, left, mid - 1);
        }

    }

}
