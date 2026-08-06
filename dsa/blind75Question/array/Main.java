package dsa.blind75Question.array;

import dsa.blind75Question.binary.SumOfInteger;
import dsa.blind75Question.string.LongestRepeatingCharacterReplacement;
import dsa.blind75Question.string.LongestSubstringWithoutRepeatingChr;
import dsa.blind75Question.string.MinimumWindowSubstring;

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
        System.out.println(MinimumWindowSubstring.minWindow("ADOBECODEBANC","ABC"));
    }

    public static void printArray(int []nums){
        System.out.println(Arrays.toString(nums));
    }
}
