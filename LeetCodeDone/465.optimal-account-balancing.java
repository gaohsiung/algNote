import java.util.*;
/*
 * @lc app=leetcode id=465 lang=java
 *
 * [465] Optimal Account Balancing
 */

// @lc code=start
class Solution {
  public int minTransfers(int[][] transactions) {
    Map<Integer, Integer> personToBalance = new HashMap<>();
    int minPerson = Integer.MAX_VALUE;
    int maxPerson = Integer.MIN_VALUE;
    for (int[] tran: transactions) {
      personToBalance.put(tran[0], personToBalance.getOrDefault(tran[0], 0) - tran[2]);
      personToBalance.put(tran[1], personToBalance.getOrDefault(tran[1], 0) + tran[2]);
      minPerson = Math.min(Math.min(minPerson, tran[0]), tran[1]);
      maxPerson = Math.max(Math.max(maxPerson, tran[0]), tran[1]);
    }
    return dfs(minPerson, maxPerson, personToBalance);
  }
  private int dfs(int cur, int maxPerson, Map<Integer, Integer> map) {
    while (cur <= maxPerson && (!map.containsKey(cur) || map.get(cur) == 0)) {
      cur++;
    }
    if (cur > maxPerson) {
      return 0;
    }
    int res = Integer.MAX_VALUE;
    for (int next = cur+1; next <= maxPerson; next++) {
      if (map.containsKey(next) && map.get(next) * map.get(cur) < 0) {
        int temp = map.get(next);
        map.put(next, temp + map.get(cur));
        res = Math.min(res, dfs(cur+1, maxPerson, map) + 1);
        map.put(next, temp);
      }
    }
    return res;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.minTransfers(new int[][]{{0,1,10},{2,0,5}});
  }
}
// @lc code=end


