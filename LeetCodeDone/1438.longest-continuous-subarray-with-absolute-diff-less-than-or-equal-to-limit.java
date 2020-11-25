import java.util.*;
/*
 * @lc app=leetcode id=1438 lang=java
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */

// @lc code=start
class Solution {
  public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> getMin = new ArrayDeque<>();
    Deque<Integer> getMax = new ArrayDeque<>();
    int left = 0;
    int res = 0;
    for (int right = 0; right < nums.length; right++) {
      while(!getMin.isEmpty() && getMin.peekLast() > nums[right]) {
        getMin.pollLast();
      }
      getMin.offerLast(nums[right]);
      while (!getMax.isEmpty() && getMax.peekLast() < nums[right]) {
        getMax.pollLast();
      }
      getMax.offerLast(nums[right]);

      while (Math.abs(getMin.peekFirst() - getMax.peekFirst()) > limit) {
        if (getMin.peekFirst() == nums[left]) {
          getMin.pollFirst();
        }
        if (getMax.peekFirst() == nums[left]) {
          getMax.pollFirst();
        }
        left++;
      }
      res = Math.max(res, right - left + 1);
    }
    return res;
  }
}
// @lc code=end
