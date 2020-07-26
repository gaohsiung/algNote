/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {

        int[] res = new int[num+1];
        if (num == 0) return res;

        for(int i = 1; i < res.length; i++) {
            res[i] = res[i&(i-1)]+1;
        }
        return res;

        
    }
}
// @lc code=end

