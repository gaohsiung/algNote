/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev1 = 1;
        int prev2 = 2;
        int i = 3;
        int cur = 2;
        while (i++ <= n) {
            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }
    public static void main(String[] sss) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(2));
    }
}
// @lc code=end

