import java.util.Stack;

/*
 * @lc app=leetcode id=255 lang=java
 *
 * [255] Verify Preorder Sequence in Binary Search Tree
 */

// @lc code=start
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // c.c.

        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;
        for(int n: preorder) {
            if (n <= lowerBound || (!stack.isEmpty() && stack.peek() == n)) return false;
            if (stack.isEmpty() || stack.peek() > n) {
                stack.push(n);
            } else {
                while(!stack.isEmpty() && stack.peek() < n) {
                    lowerBound = stack.pop();
                }
                stack.push(n);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.verifyPreorder(new int[]{5,2,1,3,6}));
    }
}
// @lc code=end

