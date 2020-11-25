import java.util.*;
/*
 * @lc app=leetcode id=1425 lang=java
 *
 * [1425] Constrained Subsequence Sum
 */

// @lc code=start
class Solution {
  public int constrainedSubsetSum(int[] nums, int k) {
    int[] dp = new int[nums.length];
    int globalMax = Integer.MIN_VALUE;
    Deque<Integer> getMaxDeque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      int localMax = Math.max(0, getMaxDeque.isEmpty()?0:getMaxDeque.peekFirst());
      dp[i] = localMax+nums[i];
      globalMax = Math.max(globalMax, dp[i]);
      if (i-k>=0 && !getMaxDeque.isEmpty() && getMaxDeque.peekFirst() == dp[i-k]) {
        getMaxDeque.pollFirst();
      }
      while (!getMaxDeque.isEmpty() && getMaxDeque.peekLast() < dp[i]) {
        getMaxDeque.pollLast();
      }
      getMaxDeque.offerLast(dp[i]);
    }
    return globalMax;
  }
}
// @lc code=end
/* no deque
class Solution {
  public int constrainedSubsetSum(int[] nums, int k) {
    int[] dp = new int[nums.length];
    int globalMax = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int localMax = 0;
      for (int j = i-k >=0?i-k:0; j < i; j++) {
        localMax = Math.max(dp[j], localMax);
      }
      dp[i] = localMax+nums[i];
      globalMax = Math.max(globalMax, dp[i]);
    }
    return globalMax;
  }
}
*/