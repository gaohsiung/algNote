/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }
        for(int i = 0; i < nums.length - k; i++) {
            nums[nums.length - 1 - i] = nums[nums.length - k - 1 - i];
        }
        for(int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        return;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
// @lc code=end

