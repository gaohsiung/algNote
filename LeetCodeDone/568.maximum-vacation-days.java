/*
 * @lc app=leetcode id=568 lang=java
 *
 * [568] Maximum Vacation Days
 */

// @lc code=start
class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cityNumber = flights.length;
        int totalweeks = days[0].length;
        int[] dp = new int[cityNumber];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = days[i][totalweeks - 1];
        }
        int[] prevDp = dp;
        for (int w = totalweeks - 2; w >= 0; w--) {
            dp = new int[cityNumber];
            for (int curCity = 0; curCity < dp.length; curCity++) {
                int max = 0;
                for(int nextCity = 0; nextCity < cityNumber; nextCity++) {
                    if (nextCity != curCity && flights[curCity][nextCity] == 0) continue;
                    max = Math.max(max, prevDp[nextCity]);
                }
                dp[curCity] = days[curCity][w] + max;
            }
            prevDp = dp;
        }

        int max = 0;
        for(int nextCity = 0; nextCity < cityNumber; nextCity++) {
            if (nextCity != 0 && flights[0][nextCity] == 0) continue;
            max = Math.max(max, prevDp[nextCity]);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxVacationDays(new int[][]{{0,1,1},{1,0,1},{1,1,0}}, new int[][]{{1,3,1}, {6,0,3},{3,3,3}}));
    }
}
// @lc code=end

