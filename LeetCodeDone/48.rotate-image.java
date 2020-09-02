/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        helper(matrix, 0, matrix.length);
        return;
    }

    private void helper(int[][] matrix, int offset, int size) {
        if (size <= 1) return;
        int[] temp = new int[size-1];
        for (int j = 0; j < size - 1; j++) {
            temp[j] = matrix[offset][offset+j];
        }
        for(int k = 0; k < size - 1; k++) {
            matrix[offset][offset+k] = matrix[offset+size-1-k][offset];
            matrix[offset+size-1-k][offset] = matrix[offset+size-1][offset+size-1-k];
            matrix[offset+size-1][offset+size-1-k] = matrix[offset+k][offset+size-1];
            matrix[offset+k][offset+size-1] = temp[k];
        }
        helper(matrix, offset+1, size-2);
    }
}
// @lc code=end

