package dsa.blind75Question.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
LC 739
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
 which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
 */
public class DailyTemperature {


    public static int[] dailyTemperatures(int[] temperatures) {

        return nextGreaterElement(temperatures);


    }

    public static int[] nextGreaterElement(int[] nums) {

        int[] ans = new int[nums.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);


        }

        return ans;

    }


}
