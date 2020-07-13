/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[tLen + 1][sLen + 1];
        for (int i = 0; i <= tLen; i++) {
            for (int j = i; j <= sLen; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (t.charAt(i-1) != s.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }

            }
        }
        return dp[tLen][sLen];
    }
}
// @lc code=end

