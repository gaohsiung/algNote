/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
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
        int left = 0;
        int right = rowNum * colNum - 1;
        int mid;
        int cur;
        while (left <= right) {
            mid = left + (right - left) / 2;
            cur = matrix[mid/colNum][mid%colNum];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end

