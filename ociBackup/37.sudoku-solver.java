/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        if (!dfs(0, board)){
            throw new IllegalArgumentException();
        }
    }

    private boolean dfs(int index, char[][] board) {
        if (index == 81) {
            return true;
        }
        int rowIndex = index / 9;
        int colIndex = index % 9;
        if (board[rowIndex][colIndex] != '.') {
            return dfs(index+1, board);
        }
        for (char i = '1'; i <= '9'; i++) {
            if (isValid(board, rowIndex, colIndex, i)) {
                board[rowIndex][colIndex] = i;
                // int nextRowIndex = (c == 8 ? r+1:r);
                // int nextColIndex = (c+1) % 9;
                if (dfs(index+1, board)) {
                    return true;
                }
                board[rowIndex][colIndex] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int rowIndex, int colIndex, char cur) {
        for (int i = 0; i < 9; i++) {
            if (board[i][colIndex] != '.' && board[i][colIndex] == cur) {
                return false;
            }
            if (board[rowIndex][i] != '.' && board[rowIndex][i] == cur) {
                return false;
            }
            if (board[(rowIndex/3)*3 + i/3][(colIndex/3)*3 + i%3] != '.' 
            && board[(rowIndex/3)*3 + i/3][(colIndex/3)*3 + i%3] == cur) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

