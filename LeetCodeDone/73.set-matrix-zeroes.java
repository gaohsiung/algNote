import java.util.*;

/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> zeros = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(i*col+j);
                }
            }
        }
        for(int zero: zeros) {
            int i = zero / col;
            int j = zero % col;
            for(int ii = 0; ii < row; ii++) {
                matrix[ii][j] = 0;
            }
            for (int jj = 0; jj < col; jj++) {
                matrix[i][jj] = 0;
            }
        }
        return;
        
    }
}
// @lc code=end

