/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class Solution {
  public int numberOfSubarrays(int[] nums, int k) {
    // c.c.
    return atMostK(nums, k) - atMostK(nums, k-1);
  }
  private int atMostK(int[] nums, int k) {
    int res = 0;
    int left = 0;
    int countOdd = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] % 2 == 1) {
        countOdd++;
      }
      while (countOdd > k) {
        if (nums[left] % 2 == 1) {
          countOdd--;
        }
        left++;
      }
      res += right - left + 1;
    }
    return res;
  }
}
// @lc code=end
