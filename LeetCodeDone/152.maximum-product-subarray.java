/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxPos = 1;
        int maxNeg = 1;
        int max = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n < 0) {
                int temp = maxPos;
                maxPos = maxNeg;
                maxNeg = temp;
            }
            maxPos = Math.max(maxPos*n, n);
            maxNeg = Math.min(maxNeg*n, n);
            max = Math.max(maxPos, max);
        }
        return max;

    }
}
// @lc code=end

