import java.util.*;
/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
  public int mincostTickets(int[] days, int[] costs) {
    if (days == null || days.length == 0) {
      return 0;
    }
    int[] dp = new int[days.length];
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int i = 0; i < days.length; i++) {
      // if buy day 1
      if (i == 0) {
        dp[i] = costs[0];
      } else {
        dp[i] = Math.min(dp[i], costs[0] + dp[i-1]);
      }
      // if buy day 7
      for (int j = i; j < days.length; j++) {
        if (j == 0) {
          dp[j] = Math.min(dp[j], costs[1]);
        } else {
          if (days[j] >= days[i] + 7) {
            break;
          }
          if (i == 0) {
            dp[j] = Math.min(dp[j], costs[1]);
          } else {
            dp[j] = Math.min(dp[j], dp[i-1] + costs[1]);
          }
        }
      }
      // if buy day 30
      for (int j = i; j < days.length; j++) {
        if (j == 0) {
          dp[j] = Math.min(dp[j], costs[2]);
        } else {
          if (days[j] >= days[i] + 30) {
            break;
          }
          if (i == 0) {
            dp[j] = Math.min(dp[j], costs[2]);
          } else {
            dp[j] = Math.min(dp[j], dp[i-1] + costs[2]);
          }
          
        }
      }
    }
    return dp[days.length - 1];
  }
}
// @lc code=end
