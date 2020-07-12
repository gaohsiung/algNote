/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean[][] isPal = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = s.length() - 1 - i;
            for (int j = i; j < s.length(); j++) {
                if (i == j || (s.charAt(i) == s.charAt(j) && (i+1 == j || isPal[i+1][j-1]))) {
                    isPal[i][j] = true;
                    if (j == s.length() - 1) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j+1]+1);
                    }
                    
                }
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minCut("aab"));
    }

}
// @lc code=end

