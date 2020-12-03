import java.util.*;
/*
 * @lc app=leetcode id=1235 lang=java
 *
 * [1235] Maximum Profit in Job Scheduling
 */

// @lc code=start
class Solution {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int len = startTime.length;
    int[][] jobs = new int[len][3];
    for (int i = 0; i < len; i++) {
      jobs[i][0] = startTime[i];
      jobs[i][1] = endTime[i];
      jobs[i][2] = profit[i];
    }
    Arrays.sort(jobs, new Comparator<int[]>(){
      @Override
      public int compare(int[] arr1, int[] arr2) {
        return arr1[0] - arr2[0];
      }
    });

    int[] mem = new int[len];
    return dfs(0, jobs, mem);
  }
  private int dfs(int curIdx, int[][] jobs, int[] mem) {
    int len = jobs.length;
    if (curIdx >= len) {
      return 0;
    }
    if (mem[curIdx] != 0) return mem[curIdx];
    int curProfit = 0;
    int nextIdx = findNextJob(curIdx, jobs);
    curProfit = Math.max(curProfit, jobs[curIdx][2] + dfs(nextIdx, jobs, mem));
    curProfit = Math.max(curProfit, dfs(curIdx+1, jobs, mem));
    mem[curIdx] = curProfit;
    return curProfit;
  }
  private int findNextJob(int curIdx, int[][] jobs) {
    int endTime = jobs[curIdx][1];
    int left = curIdx+1;
    int right = jobs.length-1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (jobs[mid][0] == endTime) {
        right = mid-1;
      } else if (jobs[mid][0] < endTime) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }

    return left;

  }
}
// @lc code=end
