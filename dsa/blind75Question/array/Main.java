package dsa.blind75Question.array;

import dsa.blind75Question.stack.NextGreaterElementII;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(TwoSum.twoSum(new int[]{3,3},6)));
//        System.out.println(BestTimeToBuyAndSell.maxProfit(new int[]{7,1,5,3,6,4}));
//        printArray(ProductOfArrayExceptItself.productExceptSelf(new int[]{1,2,3,4}));
//        System.out.println(SumOfInteger.getSum(9,111));
//        System.out.println(LongestSubstringWithoutRepeatingChr.lengthOfLongestSubstring("pwwkewxpw"));
//        System.out.println(LongestRepeatingCharacterReplacement.characterReplacement("AABABBA",1));
//        System.out.println(LongestRepeatingCharacterReplacement.characterReplacement("AABABBA",1));
//        System.out.println(MinimumWindowSubstring.minWindow("ADOBECODEBANC","ABC"));
//        System.out.println(MaximumSubArray.maxSubArray(new int[]{-2}));
//        System.out.println(MaximumProductSubArray.maxProduct(new int[]{2,3,-2,4}));
//        System.out.println(ThreeSum.threeSum(new int[]{0,0,0}));
//        System.out.println(ContainerWithMostWater.maxAreaByBruteForce(new int[]{1,8,6,2,5,4,8,3,7}));

//        printArray(SquaresOfSortedArray.sortedSquares(new int[]{-4,-1,0,3,10}));
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
//        SortColor.sortColors(arr);
//        printArray(arr);
//        System.out.println(PartitionToKEqualSubsetSum.canPartitionKSubsets(new int[]{6,5,9,6,3,5,1,10,4,1,4,3,9,9,3,
//                3},9));


//        System.out.println(Subset.subsets(new int[]{1,2,3}));

        System.out.println(MinSizeSubarraySum.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));

    }

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}
