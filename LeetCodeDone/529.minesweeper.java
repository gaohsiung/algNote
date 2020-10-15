/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1},{1, -1}, {1, 0}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int curR = click[0];
        int curC = click[1];
        if (board[curR][curC] == 'M') { // hit unrevealed mine
            board[curR][curC] = 'X';
        }
        dfs(board, click);
        return board;
    }
    private void dfs(char[][] board, int[] click) {
        int curR = click[0];
        int curC = click[1];
        if (board[curR][curC] != 'E') { // hit revealed cell
            return;
        }
        // hit 'E'
        int row = board.length;
        int col = board[0].length;
        int countMine = 0;
        for (int[] dir: DIRECTIONS) {
            int r = dir[0] + curR;
            int c = curC + dir[1];
            if (r >= 0 && r < row && c >= 0 && c < col && board[r][c] == 'M') {
                countMine++;
            }
        }
        if (countMine != 0) { // if surrounded by the mine, return
            board[curR][curC] = (char) ('0' + countMine);
            return;
        } else {
            board[curR][curC] = 'B';
        }
        // recursive call
        for (int[] dir: DIRECTIONS) {
            int r = dir[0] + curR;
            int c = curC + dir[1];
            if (r >= 0 && r < row && c >= 0 && c < col && board[r][c] != 'M') {
                dfs(board, new int[]{r, c});
            }
        }


    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.updateBoard(new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}}, new int[]{3, 0});
    }
}
// @lc code=end

