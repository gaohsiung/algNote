import java.util.Arrays;

/*
 * @lc app=leetcode id=727 lang=java
 *
 * [727] Minimum Window Subsequence
 */

// @lc code=start
class Solution {
  public String minWindow(String s, String target) {
    if (target.length() == 1) {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == target.charAt(0)) {
          return target;
        }
      }
      return "";
    }
    int[][] dp = new int[s.length()][target.length()];
    for (int[] a: dp) {
      Arrays.fill(a, -1);
    }
    int globalMin = Integer.MAX_VALUE;
    int globalMinIdx = -1;
    for (int sIdx = 0; sIdx < s.length(); sIdx++) {
      for (int tIdx = 0; tIdx < target.length(); tIdx++) {
        if (s.charAt(sIdx) == target.charAt(tIdx)) {
          if (sIdx == 0 && tIdx == 0) {
            dp[sIdx][tIdx] = 0;
          } else if (sIdx == 0) {
            dp[sIdx][tIdx] = -1;
          } else if (tIdx == 0) {
            dp[sIdx][tIdx] = sIdx;
          } else if (dp[sIdx - 1][tIdx - 1] != -1) {
            dp[sIdx][tIdx] = dp[sIdx - 1][tIdx - 1];
            if (tIdx == target.length() - 1) {
              if (globalMin > sIdx - dp[sIdx][tIdx] + 1) {
                globalMin = sIdx - dp[sIdx][tIdx] + 1;
                globalMinIdx = dp[sIdx][tIdx];
              }
            }
          }
        } else {
          dp[sIdx][tIdx] = dp[sIdx - 1 >= 0 ? sIdx - 1:0][tIdx];
        }
      }
    }
    return globalMinIdx == -1 ? "":s.substring(globalMinIdx, globalMinIdx + globalMin);
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.minWindow("abcdebdde", "bde");
  }
}
// @lc code=end
