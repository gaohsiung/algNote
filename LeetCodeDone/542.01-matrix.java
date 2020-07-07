import java.util.*;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[][]{{}};
        }
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Integer> q = new LinkedList<>();
        int[][] res = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(i*col + j);
                }
            }
        }
        int minLen = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int temp = 0; temp < size; temp++) {
                int cur = q.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[]dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col 
                        && matrix[ii][jj] != 0 && res[ii][jj] == 0) {
                        res[ii][jj] = minLen;
                        q.offer(ii*col + jj);
                    }
                }
            }
            minLen++;
        }
        return res;

    }
}
// @lc code=end

