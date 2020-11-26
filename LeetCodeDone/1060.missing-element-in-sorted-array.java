/*
 * @lc app=leetcode id=1060 lang=java
 *
 * [1060] Missing Element in Sorted Array
 */

// @lc code=start
class Solution {
  public int missingElement(int[] nums, int k) {
    if (nums.length == 1) {
      return nums[0] + k;
    }
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      int leftMissNo = (nums[mid] - nums[start]) - 1 - (mid - start - 1);
      if (leftMissNo >= k) {
        end = mid;
      } else {
        start = mid;
        k = k - leftMissNo;
      }
    }
    if (nums[end] - nums[start] - 1 < k) {
      return nums[end] + k - (nums[end] - nums[start] - 1);
    }
    return nums[start] + k;

  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.missingElement(new int[]{1,2,4}, 3));
  }
}
// @lc code=end
