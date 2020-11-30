import java.util.*;
/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 */

// @lc code=start
class Solution {
  public int longestArithSeqLength(int[] nums) {
    int len = nums.length;
    Map<Integer, Integer>[] dp = new Map[len];
    int globalLongest = 2;
    for (int i = 1; i < len; i++) {
      dp[i] = new HashMap<>();
      for (int j = 0; j < i; j++) {
        int diff = nums[i] - nums[j];
        if (j == 0) {
          dp[i].put(diff, 2);
          continue;
        }
        if (dp[j].containsKey(diff)) {
          dp[i].put(diff, dp[j].get(diff) + 1);
          globalLongest = Math.max(globalLongest, dp[j].get(diff) + 1);
        } else {
          dp[i].put(diff, 2);
        }
      }
    }
    return globalLongest;

  }
}
// @lc code=end
