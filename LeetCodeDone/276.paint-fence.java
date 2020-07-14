/*
 * @lc app=leetcode id=276 lang=java
 *
 * [276] Paint Fence
 */

// @lc code=start
class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int diff = (k - 1) * k;
        int same = k;
        for (int i = 2; i < n; i++) {
            int prevDiff = diff;
            diff = (diff + same) * (k-1);
            same = prevDiff;
        }
        return diff+same;


    }
}
// @lc code=end

