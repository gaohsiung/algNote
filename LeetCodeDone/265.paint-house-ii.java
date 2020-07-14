import java.util.*;

/*
 * @lc app=leetcode id=265 lang=java
 *
 * [265] Paint House II
 */

// @lc code=start
class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int row = costs.length;
        int col = costs[0].length;

        int[][] dp = new int[row][col];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0){
                    dp[i][j] = costs[i][j];
                    continue;
                }
                min = Integer.MAX_VALUE;
                for (int k = 0; k < col; k++) {
                    if (k == j) continue;
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        int finalMin = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            finalMin = Math.min(finalMin, dp[row-1][j]);
        }
        return finalMin;
        
    }
    public static void main(String[] args) {

    }
}
// @lc code=end

