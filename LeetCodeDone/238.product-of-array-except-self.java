/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] ret = new int[nums.length];
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i-1] * nums[i-1];
        }
        int rightProducts = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = ret[i] * rightProducts;
            rightProducts *= nums[i];
        }
        return ret;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.productExceptSelf(new int[]{1,2,3,4}));
    }
}
// @lc code=end

