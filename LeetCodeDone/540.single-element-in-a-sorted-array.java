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
    while (left < right) {
      int mid = left + (right - left) / 2;
      int leftNo = mid - left + 1;
      int rightNo = right - mid + 1;
      if (nums[mid] == nums[mid-1]) {
        if (leftNo%2 == 0) {
          left = mid + 1;
        } else {
          right = mid;
        }
      } else if (nums[mid] == nums[mid+1]) {
        if (rightNo%2 == 0) {
          right = mid-1;
        } else {
          left = mid;
        }
      } else {
          return nums[mid];
      }
    }

    return nums[left];
  }
  
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.singleNonDuplicate(new int[]{7,7,10,11,11,12,12}));
  }
}
// @lc code=end
