package dsa.blind75Question.dp;

import java.util.Arrays;

/*
LC 62
here is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot
 tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at
  any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.



Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePathDP(m, n, 1, 1, dp);


    }

    private static int uniquePathDP(int m, int n, int currRow, int currCol, int[][] dp) {

        if (currRow > m || currCol > n || currRow < 1 || currCol < 1)
            return 0;

        if (currRow == m && currCol == n)
            return 1;

        if (dp[currRow][currCol] != -1)
            return dp[currRow][currCol];

        int right = uniquePathDP(m, n, currRow, currCol + 1, dp);
        int down = uniquePathDP(m, n, currRow + 1, currCol, dp);

        dp[currRow][currCol] = right + down;

        return right + down;


    }


    private static int uniquePath(int m, int n, int currRow, int currCol) {

        if (currRow > m || currCol > n || currRow < 1 || currCol < 1)
            return 0;

        if (currRow == m && currCol == n)
            return 1;

        int right = uniquePath(m, n, currRow, currCol + 1);
        int down = uniquePath(m, n, currRow + 1, currCol);
        return right + down;


    }

}
