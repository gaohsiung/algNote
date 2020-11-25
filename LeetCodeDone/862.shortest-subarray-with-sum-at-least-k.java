import java.util.*;
/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
class Solution {
    public int shortestSubarray(int[] nums, int k) {
      int[] prefixSum = new int[nums.length+1];
      for (int i = 0; i < nums.length; i++) {
        prefixSum[i+1] = nums[i] + prefixSum[i];
      }

      int globalMin = nums.length+1;
      Deque<Integer> increaseDeque = new ArrayDeque<>();
      // prefixSum[right] +(- prefixSum[left]) >= k --> [left+1, right]
      for (int right = 0; right <= nums.length; right++) {
        while (!increaseDeque.isEmpty() && prefixSum[right] - prefixSum[increaseDeque.peekFirst()] >= k) {
          globalMin = Math.min(globalMin, right - increaseDeque.pollFirst());
        }
        while (!increaseDeque.isEmpty() && prefixSum[increaseDeque.peekLast()] >= prefixSum[right]) {
          increaseDeque.pollLast();
        }
        increaseDeque.offerLast(right);
      }
      return globalMin == nums.length+1?-1:globalMin; 
    }
}
// @lc code=end

