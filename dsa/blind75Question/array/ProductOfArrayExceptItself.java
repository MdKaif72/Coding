package dsa.blind75Question.array;

/*
238. Product of Array Except Self
Hint
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

import java.util.Arrays;

public class ProductOfArrayExceptItself {

    /*
    First Approach
    initial Approach where we have taken two array left and right and simply multiplying left and right array

    public static int[] productExceptSelf(int[] nums) {
        int [] leftArray=new int[nums.length];
        int [] rightArray=new int[nums.length];
        leftArray[0]=1;
        int prod=1;
        for(int i=0;i<nums.length;i++){
            leftArray[i]=prod;
            prod*=nums[i];

        }
        prod=1;
        for(int i=nums.length-1;i>=0;i--){
            rightArray[i]=prod;
            prod*=nums[i];

        }
        System.out.println(Arrays.toString(rightArray));
        for(int i=0;i<nums.length;i++){
            rightArray[i]=rightArray[i]*leftArray[i];
        }
        return rightArray;

    }
     */

    public static int[] productExceptSelf(int[] nums) {
        int [] leftArray=new int[nums.length];
        int [] rightArray=new int[nums.length];
        int prod=1;
        for(int i=0;i<nums.length;i++){
            leftArray[i]=prod;
            prod*=nums[i];

        }
        prod=1;
        for(int i=nums.length-1;i>=0;i--){
            rightArray[i]=prod;
            prod*=nums[i];

        }
        for(int i=0;i<nums.length;i++){
            rightArray[i]=rightArray[i]*leftArray[i];
        }
        return rightArray;

    }

}
