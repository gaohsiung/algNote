/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            if (nums[start] != val) {
                start++;
                continue;
            }
            if (nums[end] == val) {
                end--;
                continue;
            }
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        return start;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.removeElement(new int[]{2}, 3);
    }
}
// @lc code=end

