import java.util.*;
/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */

// @lc code=start
class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    if (nums == null || nums.length <= 1) {
      return false;
    }
    int prev = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (prev == 0 && nums[i] == 0) {
        return true;
      }
      prev = nums[i];
    }

    if (k == 0) {
      return false;
    }
    Map<Integer, Integer> cumSum = new HashMap<>();
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (i != 0 && sum % k == 0) {
        return true;
      }
      sum %= k;
      if (!cumSum.containsKey(sum)) {
        cumSum.put(sum, i);
      } else {
        if (i - cumSum.get(sum) > 1) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.checkSubarraySum(new int[] {422,224,184,178,189,290,196,236,281,464,351,193,49,76,0,298,193,176,158,514,312,143,475,322,206,67,524,424,76,99,473,256,364,292,141,186,190,69,433,205,93,72,476,393,512,468,160,201,226,394,47,140,389,51,142,135,349,244,16,356,440,188,16,133,58,394,7,517,56,480,400,146,169,439,102,374,370,242,4,264,120,218,196,173,215,411,501,321,319,147,369,458,319,174,379,46,129,353,330,101}, 479));
  }
}
// @lc code=end
