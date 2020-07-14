/*
 * @lc app=leetcode id=256 lang=java
 *
 * [256] Paint House
 */

// @lc code=start
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int houseNum = costs.length;
        int colorNum = costs[0].length;
        int[] dp;
        int[] prev = new int[colorNum];
        for (int houseIdx = 0; houseIdx < houseNum; houseIdx++) {
            dp = new int[colorNum];
            for (int colorIdx = 0; colorIdx < colorNum; colorIdx++) {
                if (houseIdx == 0) {
                    dp[colorIdx] = costs[houseIdx][colorIdx];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int prevColorIdx = 0; prevColorIdx < colorNum; prevColorIdx++) {
                    if (prevColorIdx == colorIdx) continue;
                    min = Math.min(min, prev[prevColorIdx]);
                }
                dp[colorIdx] = costs[houseIdx][colorIdx] + min;
            }
            prev = dp;
        }
        int min = Integer.MAX_VALUE;
        for (int i: prev) {
            min = Math.min(i, min);
        }
        return min;
    }
}
// @lc code=end

