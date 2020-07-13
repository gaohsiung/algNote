/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {// two empty string
                    dp[i][j] = true;
                } else if (i == 0) {//s1 is empty
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
                } else if (j == 0) {//s2 is empty
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1);
                } else {
                    int i3 = i-1 + j-1 + 1;
                    if ((s3.charAt(i3) != s1.charAt(i-1)) && (s3.charAt(i3) != s2.charAt(j-1))) {
                        dp[i][j] = false;
                    } else if ((s3.charAt(i3) == s1.charAt(i-1)) && (s3.charAt(i3) == s2.charAt(j-1))) {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    } else if (s3.charAt(i3) == s2.charAt(j-1)) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

