/*
 * @lc app=leetcode id=1304 lang=java
 *
 * [1304] Find N Unique Integers Sum up to Zero
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int start = 0;
        int end = n - 1;
        int i = 1;
        while(start < end) {
            res[start++] = i;
            res[end--] = -i;
            i++;
        }
        return res;
    }
}
// @lc code=end

