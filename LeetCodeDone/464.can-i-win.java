/*
 * @lc app=leetcode id=464 lang=java
 *
 * [464] Can I Win
 */

// @lc code=start
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger <= 0 || (1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal ) {
            return false;
        }
        if (desiredTotal == 0) {
            return true;
        }
        
        if (maxChoosableInteger > 20) {
            throw new IllegalArgumentException();
        }
        int status = (1 << maxChoosableInteger) - 1;
        return dfs(status, desiredTotal, new Boolean[status+1]);
        
    }

    private boolean dfs(int status, int remain, Boolean[] mem) {
        if (remain <= 0) {
            return false;
        }
        if (mem[status] != null) {
            return mem[status];
        }

        for (int i = 0; i < 20; i++){
            int mask = 1 << i;
            if ((status & mask) != 0) {
                status -= mask;
                if (!dfs(status, remain - (i+1), mem)) {
                    return true;
                }
                status += mask;

            }
        }
        mem[status] = false;
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canIWin(10, 11));
    }
}
// @lc code=end

