/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
  public int longestOnes(int[] nums, int k) {
    // c.c.
    int left = 0;
    int globalMax = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        k--;
      }
      if (k >= 0) {
        globalMax = Math.max(right - left + 1, globalMax);
      }
      if (k == -1) {
        globalMax = Math.max(right - left, globalMax);
      }
      while (k == -1) {
        if (nums[left] == 0) {
          k++;
        }
        left++;
      }
    }
    return globalMax;
  }
}
// @lc code=end
