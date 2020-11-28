/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
  public int singleNonDuplicate(int[] nums) {
    // c.c.
    //e.c.
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums[0] != nums[1]) {
      return nums[0];
    }
    int len = nums.length;
    if (nums[len-1] != nums[len - 2]) return nums[len - 1];
    int left = 0;
    int right = len - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      int leftNo = mid - left + 1;
      if (leftNo%2 == 0) {
        if (nums[mid] == nums[mid-1]) {
          left = mid;
        } else if (nums[mid] == nums[mid+1]) {
          right = mid;
        }
      } else if (leftNo%2 == 1) {
        if (nums[mid] == nums[mid+1]) {
          left = mid;
        } else if (nums[mid] == nums[mid-1]) {
          right = mid;
        }
      } else {
        return nums[mid];
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.singleNonDuplicate(new int[]{7,7,10,11,11,12,12});
  }
}
// @lc code=end
