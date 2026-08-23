package dsa.blind75Question.matrix;

import java.net.Inet4Address;
import java.util.Arrays;

/*
LC 994
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return
 -1.



Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens
4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */
public class RottingOrange {

    public static int orangesRotting(int[][] grid) {


        int rows = grid.length;
        int cols = grid[0].length;

        int[][] time = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(time[i], Integer.MAX_VALUE);
            }
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, time, i, j, 0);
                }

            }
        }
        int daysRequired = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (time[i][j] == Integer.MAX_VALUE)
                        return -1;
                    daysRequired = Math.max(daysRequired, time[i][j]);
                }

            }
        }
        return daysRequired;

    }

    private static void dfs(int[][] grid, int[][] time, int i, int j, int currDay) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || currDay >= time[i][j])
            return;

        time[i][j] = currDay;

        //All the direction
        dfs(grid, time, i + 1, j, currDay + 1);
        dfs(grid, time, i - 1, j, currDay + 1);
        dfs(grid, time, i, j + 1, currDay + 1);
        dfs(grid, time, i, j - 1, currDay + 1);
    }
}
