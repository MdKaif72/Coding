package dsa.blind75Question.dp;

/*
LC 70
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

public class ClimbingStair {

    public int climbStairs(int n) {

        /*
        this will give TLE
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);
        return left + right;
         */
        return dp(n,new int[n+1]);


    }

    public int dp(int n, int[] arr) {
        if (n <= 2) {
            return n;
        }
        if (arr[n] != 0)
            return arr[n];

        int left = dp(n - 1, arr);
        int right = dp(n - 2, arr);

        arr[n] = left + right;

        return left + right;

    }

}
