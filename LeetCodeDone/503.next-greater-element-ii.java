import java.util.*;
/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
  public int[] nextGreaterElements(int[] nums) {
    // c.c.
    int len = nums.length;
    int[] res = new int[len];
    Arrays.fill(res, -1);
    Deque<Integer> stack = new ArrayDeque<>();
    int idx = 0;
    while (idx < len*2) {
      int i = idx % len;
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        res[stack.pop()] = nums[i];
      }
      stack.push(i);
      idx = idx+1;
    }
    
    return res;
  }
}
// @lc code=end
