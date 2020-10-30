import java.util.Arrays;

/*
 * @lc app=leetcode id=1335 lang=java
 *
 * [1335] Minimum Difficulty of a Job Schedule
 */

// @lc code=start
class Solution {
  public int minDifficulty(int[] jobDifficulty, int d) {

    if (jobDifficulty.length < d) {
      return -1;
    }
    int[][] mem = new int[jobDifficulty.length][d+1];
    for (int[] a: mem) {
      Arrays.fill(a, -1);
    }
    return dfs(jobDifficulty, 0, d, mem);
  }
  private int dfs(int[] jobDifficulty, int curJobIndex, int curDay, int[][] mem) {
    if (curDay == 1) {
      int res = 0;
      for (int i = curJobIndex; i < jobDifficulty.length; i++) {
        res = Math.max(res, jobDifficulty[i]);
      }
      mem[curJobIndex][curDay] = res;
      return res;
    }
    if (mem[curJobIndex][curDay] != -1) {
      return mem[curJobIndex][curDay];
    }
    int curMax = 0;
    int res = Integer.MAX_VALUE;
    for (int i = curJobIndex; i < jobDifficulty.length - curDay + 1; i++) {
      curMax = Math.max(curMax, jobDifficulty[i]);
      res = Math.min(res, curMax + dfs(jobDifficulty, i+1, curDay-1, mem));
    }
    mem[curJobIndex][curDay] = res;
    return res;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.minDifficulty(new int[]{11,111,22,222,33,333,44,444}, 6));
  }
}
// @lc code=end
