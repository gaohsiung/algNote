import java.util.Arrays;

/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] matrix = new int[n][n];
        int offset = 0;
        int size = n;
        int value = 1;

        while (size > 0) {
            if (size == 1) {
                matrix[offset][offset] = value;
                break;
            }
            for (int i = 0; i < size - 1; i++) {
                matrix[offset][offset + i] = value;
                value++;
            }
            for (int i = 0; i < size - 1; i++) {
                matrix[offset + i][offset + size - 1] = value;
                value++;
            }
            for (int i = 0; i < size - 1; i++) {
                matrix[offset + size - 1][offset + size - 1 - i] = value;
                value++;
            }
            for (int i = 0; i < size - 1; i++) {
                matrix[offset + size - 1 - i][offset] = value;
                value++;
            }
            offset++;
            size -= 2;


        }
        return matrix;

    }
    public static void main(String[] args) {

    }
}
// @lc code=end

