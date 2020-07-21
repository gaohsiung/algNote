/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // c.c.

        int start = 0;
        int end = height.length - 1;
        int max = Math.min(height[end], height[start]) * (end - start);

        while(start < end) {
            if (height[start] > height[end]) {
                while(start < end && height[end-1] <= height[end]) {
                    end--;
                }
                end--;
            } else {
                while(start < end && height[start+1] <= height[start]) {
                    start++;
                }
                start++;
            }
            if(start < end) {
                max = Math.max(max, Math.min(height[end], height[start]) * (end - start));
            }
        }
        return max;
        
    }
}
// @lc code=end

