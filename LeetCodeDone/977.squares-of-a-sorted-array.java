/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
  public int[] sortedSquares(int[] nums) {
    int len = nums.length;
    int startIdx;
    if (nums[0] >= 0) {
      startIdx = 0;
    } else if (nums[len - 1] <= 0) {
      startIdx = len - 1;
    } else {
      startIdx = findIdxCloseToZero(nums);
    }
    int[] res = new int[nums.length];
    res[0] = nums[startIdx] * nums[startIdx];
    int resPointer = 1;
    int left = startIdx - 1;
    int right = startIdx + 1;
    while (left >= 0 && right <= len - 1) {
      if (Math.abs(nums[left]) < Math.abs(nums[right])) {
        res[resPointer++] = nums[left] * nums[left];
        left--;
      } else {
        res[resPointer++] = nums[right] * nums[right];
        right++;
      }
    }
    while (left >= 0) {
      res[resPointer++] = nums[left] * nums[left];
      left--;
    }
    while (right <= len - 1) {
      res[resPointer++] = nums[right] * nums[right];
      right++;
    }
    return res;
  }
  private int findIdxCloseToZero(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == 0) {
        return mid;
      } else if (nums[mid] > 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return Math.abs(nums[left]) > Math.abs(nums[right])?right:left;
  }
}
// @lc code=end
