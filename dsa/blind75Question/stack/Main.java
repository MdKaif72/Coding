package dsa.blind75Question.stack;

import dsa.blind75Question.array.DailyTemperature;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


//        System.out.println(LargestRectangleInHistogram.maxAreaByBruteForce(new int[]{2, 1, 5, 6, 2, 3}));
//        printArray(NextGreaterElementUsingStack.nextGreaterElement(new int[]{2, 4, 0, 9, 6}));
//        printArray(NextGreaterElementII.nextGreaterElement(new int[]{1, 2, 1}));
//        printArray(NextGreaterElementI.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        printArray(DailyTemperature.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

}
