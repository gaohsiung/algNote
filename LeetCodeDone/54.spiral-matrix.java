import java.util.*;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int offset = 0;
        while (rowSize > 0 && colSize > 0) {
            if (rowSize == 1) {
                for (int i = 0; i < colSize; i++) {
                    res.add(matrix[offset][offset+i]);
                }
                break;
            }
            if (colSize == 1) {
                for (int i = 0; i < rowSize; i++) {
                    res.add(matrix[offset+i][offset]);
                }
                break;
            }
            for (int i = 0; i < colSize - 1; i++) {
                res.add(matrix[offset][offset+i]);
            }
            for (int i = 0; i < rowSize - 1; i++) {
                res.add(matrix[offset + i][offset+ colSize - 1]);
            }
            for (int i = 0; i < colSize - 1; i++) {
                res.add(matrix[offset + rowSize - 1][offset + colSize - 1 - i]);
            }
            for (int i = 0; i < rowSize - 1; i++) {
                res.add(matrix[offset + rowSize - 1 - i][offset]);
            }
            offset++;
            rowSize -= 2;
            colSize -= 2;
        }

        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.spiralOrder(new int[][]{{1},{2},{3},{4}}));
    }
}
// @lc code=end

