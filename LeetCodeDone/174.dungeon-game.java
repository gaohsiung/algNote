/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        // dp from bottom right to top left, initialize the bottom right
        if (dungeon[row-1][col-1] < 0) { 
            dp[row - 1][col - 1] = 1 - dungeon[row-1][col-1];
        } else { // addtional 1 health to survive
            dp[row - 1][col - 1] = 1;
        }
        // dp[i][j] the least health to survive at dungeon[i][j]
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) continue;
                // next min health necessary to survive
                int nextMinHealth = Math.min(j+1>=col ? Integer.MAX_VALUE:dp[i][j+1], i+1>=row ? Integer.MAX_VALUE:dp[i+1][j]);
                if (dungeon[i][j] + 1 >= nextMinHealth) { // has enough potion to survive in future
                    dp[i][j] = 1;
                } else {// can't survive, need additional health from prev
                    dp[i][j] = nextMinHealth - dungeon[i][j];
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}
// @lc code=end

