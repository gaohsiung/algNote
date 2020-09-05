/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || 
            matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int row = rowNum - 1;
        int col = 0;
        int cur;
        while (row >= 0 && col < colNum) {
            cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                row -= 1;
            } else {
                col += 1;
            }
        }
        return false;
    }
}
// @lc code=end

