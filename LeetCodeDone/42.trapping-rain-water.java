/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int sum = 0;
        while (left + 1 < right) {
            if (leftHeight <= rightHeight) {
                left++;
                if (leftHeight > height[left]) {
                    sum = sum + leftHeight - height[left];
                }
                leftHeight = Math.max(leftHeight, height[left]);
            } else {
                right--;
                if (rightHeight > height[right]) {
                    sum = sum + rightHeight - height[right];
                }
                rightHeight = Math.max(rightHeight, height[right]);
            }
        }
        return sum;
    }
}
// @lc code=end

