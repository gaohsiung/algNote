import java.util.*;
/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 */

// @lc code=start
class Solution {
  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int i: nums) {
      counts.put(i, counts.getOrDefault(i, 0) + 1);
    }
    Map<Integer, Integer> endIdxToNo = new HashMap<>();
    for (int i: nums) {
      if (counts.get(i) == 0) {
        continue;
      }
      if (endIdxToNo.containsKey(i - 1) && endIdxToNo.get(i-1) > 0) {
        counts.put(i, counts.get(i) - 1);
        endIdxToNo.put(i - 1, endIdxToNo.get(i-1) - 1);
        endIdxToNo.put(i, endIdxToNo.getOrDefault(i, 0) + 1);
        continue;
      }
      if (counts.containsKey(i+1) && counts.containsKey(i+2) 
      && counts.get(i+1) > 0 && counts.get(i+2) > 0) {
        endIdxToNo.put(i+2, endIdxToNo.getOrDefault(i+2, 0) + 1);
        counts.put(i, counts.get(i) - 1);
        counts.put(i+1, counts.get(i+1) - 1);
        counts.put(i+2, counts.get(i+2) - 1);
        continue;
      }
      return false;
    }
    return true;
  }
}
// @lc code=end
