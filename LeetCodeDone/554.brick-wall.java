import java.util.*;
/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */

// @lc code=start
class Solution {
  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> counts = new HashMap<>();
    int globalMax = 0;
    int rows = wall.size();
    for (List<Integer> row: wall) {
      int sum = 0;
      for (int i = 0; i < row.size() - 1; i++) {
        sum += row.get(i);
        counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        globalMax = Math.max(globalMax, counts.get(sum));
      }
    }
    return rows - globalMax;
  }
}
// @lc code=end
