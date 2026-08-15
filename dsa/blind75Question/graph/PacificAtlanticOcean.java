package dsa.blind75Question.graph;

/*
LC 417
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean
touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where
heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and
west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any
cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell
(ri, ci) to both the Pacific and Atlantic oceans.



Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticOcean {

    //If it can visit both the ocean the mask value would be 3
    private static final int PACIFIC_MASK = 1;   // bit 0
    private static final int ATLANTIC_MASK = 2;  // bit 1

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        return pacificAtlanticBruteForce(heights);

        return pacificAtlanticDP(heights);


    }
    public List<List<Integer>> pacificAtlanticDP(int[][] heights) {

    List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
        return result;
    }

    int rows = heights.length;
    int cols = heights[0].length;

    boolean[][] pacific = new boolean[rows][cols];
    boolean[][] atlantic = new boolean[rows][cols];

    // Start DFS from the Pacific edges (top row and left column)
        for (int c = 0; c < cols; c++) {
        dfsFromOcean(heights, 0, c, pacific);
        dfsFromOcean(heights, rows - 1, c, atlantic);
    }
        for (int r = 0; r < rows; r++) {
        dfsFromOcean(heights, r, 0, pacific);
        dfsFromOcean(heights, r, cols - 1, atlantic);
    }

    // Collect cells that reached both oceans
        for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (pacific[r][c] && atlantic[r][c]) {
                result.add(Arrays.asList(r, c));
            }
        }
    }
        return result;
}

private void dfsFromOcean(int[][] heights, int row, int col, boolean[][] visited) {
    if (visited[row][col]) {
        return;
    }
    visited[row][col] = true;

    int rows = heights.length;
    int cols = heights[0].length;
    int currentHeight = heights[row][col];

    // Up
    if (row - 1 >= 0 && heights[row - 1][col] >= currentHeight) {
        dfsFromOcean(heights, row - 1, col, visited);
    }
    // Down
    if (row + 1 < rows && heights[row + 1][col] >= currentHeight) {
        dfsFromOcean(heights, row + 1, col, visited);
    }
    // Left
    if (col - 1 >= 0 && heights[row][col - 1] >= currentHeight) {
        dfsFromOcean(heights, row, col - 1, visited);
    }
    // Right
    if (col + 1 < cols && heights[row][col + 1] >= currentHeight) {
        dfsFromOcean(heights, row, col + 1, visited);
    }
}

    /*


    public List<List<Integer>> pacificAtlanticBruteForce(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean[][] visited = new boolean[rows][cols];
                int mask = dfs(heights, r, c, visited);

                if ((mask & PACIFIC_MASK) != 0 && (mask & ATLANTIC_MASK) != 0) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private int dfs(int[][] heights, int row, int col, boolean[][] visited) {
        int rows = heights.length;
        int cols = heights[0].length;

        visited[row][col] = true;

        int mask = 0;
        if (row == 0 || col == 0) {
            mask |= PACIFIC_MASK;
        }
        if (row == rows - 1 || col == cols - 1) {
            mask |= ATLANTIC_MASK;
        }

        if (mask == (PACIFIC_MASK | ATLANTIC_MASK)) {
            return mask;
        }

        int currentHeight = heights[row][col];

        // Down
        int nr = row + 1;
        int nc = col;
        if (nr < rows && !visited[nr][nc] && heights[nr][nc] <= currentHeight) {
            mask |= dfs(heights, nr, nc, visited);
            if (mask == (PACIFIC_MASK | ATLANTIC_MASK)) return mask;
        }

        // Up
        nr = row - 1;
        nc = col;
        if (nr >= 0 && !visited[nr][nc] && heights[nr][nc] <= currentHeight) {
            mask |= dfs(heights, nr, nc, visited);
            if (mask == (PACIFIC_MASK | ATLANTIC_MASK)) return mask;
        }

        // Right
        nr = row;
        nc = col + 1;
        if (nc < cols && !visited[nr][nc] && heights[nr][nc] <= currentHeight) {
            mask |= dfs(heights, nr, nc, visited);
            if (mask == (PACIFIC_MASK | ATLANTIC_MASK)) return mask;
        }

        // Left
        nr = row;
        nc = col - 1;
        if (nc >= 0 && !visited[nr][nc] && heights[nr][nc] <= currentHeight) {
            mask |= dfs(heights, nr, nc, visited);
        }

        return mask;
    }
     */
}
