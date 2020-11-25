/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */

// @lc code=start
class Solution {
  public int numSubarraysWithSum(int[] nums, int sum) {
    return atMostS(nums, sum) - atMostS(nums, sum - 1);
  }
  private int atMostS(int[] nums, int sum) {
    if (sum < 0) return 0;
    int res = 0;
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 1) {
        sum--;
      }
      while (sum < 0) {
        if (nums[left] == 1) {
          sum++;
        }
        left++;
      }
      res = res + right - left + 1;
    }
    return res;
  }
}
// @lc code=end
