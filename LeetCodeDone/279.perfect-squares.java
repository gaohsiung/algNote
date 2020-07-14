/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        } 
        int maxSquareRoot = (int) Math.sqrt(n);
        int[] perfectSquares = new int[maxSquareRoot+1];
        for (int i = 0; i < maxSquareRoot+1; i++) {
            perfectSquares[i] = i*i;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i < n+1; i++) {
            int curMin = Integer.MAX_VALUE;
            dp[i] = i;
            for (int ps: perfectSquares) {
                if (i - ps < 0) break;
                curMin = Math.min(curMin, dp[i - ps]);

            }
            dp[i] = curMin + 1;
        }
        return dp[n];

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numSquares(13));
    }
}
// @lc code=end

