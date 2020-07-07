import java.util.*;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] notSurround = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                q.offer(i * col);
                notSurround[i][0] = true;
            }
            if (board[i][col-1] == 'O') {
                q.offer(i * col + col - 1);
                notSurround[i][col-1] = true;
            }
        }
        for (int j = 1; j < col - 1; j++) {
            if (board[0][j] == 'O') {
                q.offer(j);
                notSurround[0][j] = true;
            }
            if (board[row-1][j] == 'O') {
                q.offer((row-1)*col+j);
                notSurround[row-1][j] = true;
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            int i = cur / col;
            int j = cur % col;
            for (int[] dir: DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col
                    && board[ii][jj] == 'O' && notSurround[ii][jj] == false) {
                    notSurround[ii][jj] = true;
                    q.offer(ii*col + jj);
                }
            }
        }
        for(int i = 0; i < row; i++) {
            for (int j = 0; j< col; j++) {
                if (!notSurround[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
}
// @lc code=end

