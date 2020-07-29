import java.util.*;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // c.c.
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && (heights[stack.peek()] > heights[i])) {
                    int curIdx = stack.pop();
                    int curHeight = heights[curIdx];
                    if (stack.isEmpty()) {
                        max = Math.max(max, (i)*curHeight);
                    } else {
                        max = Math.max(max, (i-stack.peek()-1)*curHeight);
                    }
                    
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty() && (heights[stack.peek()] > 0)) {
            int curIdx = stack.pop();
            int curHeight = heights[curIdx];
            if (stack.isEmpty()) {
                max = Math.max(max, heights.length*curHeight);
            } else {
                max = Math.max(max, (heights.length-stack.peek()-1)*curHeight);
            }
            
        }
        return max;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
// @lc code=end

