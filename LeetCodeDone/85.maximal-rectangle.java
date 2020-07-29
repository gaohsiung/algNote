import java.util.Stack;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        // c.c.
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[] dp = new int[col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (matrix[i][j] != '1') { // not 0, reset to 0
                    dp[j] = 0;
                    continue;
                } else {
                    if (i == 0) {
                        dp[j] = 1;
                    } else {
                        dp[j] = dp[j]+1;
                    }
                }
            }
            max = Math.max(max, largestRectangleForEachRow(dp));
        }
        return max;
    }

    private int largestRectangleForEachRow(int[] nums) {
        // c.c.

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (stack.peek() == -1 || nums[stack.peek()]<= nums[i]) {
                stack.push(i);
            } else {
                while(stack.peek() != -1 && nums[stack.peek()] > nums[i]) {
                    int height = nums[stack.pop()];
                    max = Math.max(max, height*(i - stack.peek() - 1));
                }
                stack.push(i);
            }
        }
        while(stack.peek() != -1) {
            int height = nums[stack.pop()];
            max = Math.max(max, height*(nums.length - stack.peek() - 1));
        }
        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
// @lc code=end

