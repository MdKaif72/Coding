package dsa.blind75Question.matrix;

/*
LC 79
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


 */

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        char[] word_arr = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && exists(board, i, j, word_arr, 0))
                    return true;
            }
        }
        return false;


    }

    private boolean exists(char[][] board, int i, int j, char[] wordArr, int indx) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        if (board[i][j] == '*' || board[i][j] != wordArr[indx])
            return false;

        if (indx == wordArr.length - 1)
            return true;


        char ch = board[i][j];
        board[i][j] = '*';


        boolean result = exists(board, i + 1, j, wordArr, indx + 1) ||
                exists(board, i - 1, j, wordArr, indx + 1) ||
                exists(board, i, j + 1, wordArr, indx + 1) ||
                exists(board, i, j - 1, wordArr, indx + 1);

        board[i][j] = ch;

        return result;

    }


}
