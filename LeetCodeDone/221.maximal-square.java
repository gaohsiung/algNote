/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    if (matrix[i][j] == '1') {
                        max = Math.max(1, max);
                    }
                    continue;
                }
                if (matrix[i][j] == '1') {
                    int cur = Math.min(Math.min((dp[i-1][j-1]), (dp[i-1][j])), (dp[i][j-1])) + 1;
                    dp[i][j] = cur;
                    max = Math.max(max, cur);
                }
            }
        }
        return max*max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0', '1', '1', '1'},{'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
// @lc code=end

