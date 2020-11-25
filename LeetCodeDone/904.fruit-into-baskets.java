import java.util.*;
/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
  public int totalFruit(int[] tree) {
    Map<Integer, Integer> counts = new HashMap<>();
    int left = 0;
    int globalMax = 0;
    int uniqueNo = 0;
    for (int right = 0; right < tree.length; right++) {
      int curTree = tree[right];
      if (!counts.containsKey(curTree) || counts.get(curTree) == 0) {
        uniqueNo++;
      }
      counts.put(curTree, counts.getOrDefault(curTree, 0) + 1);
      while (uniqueNo == 3) {
        int leftTree = tree[left];
        if (counts.get(leftTree) == 1) {
          uniqueNo--;
        }
        counts.put(leftTree, counts.get(leftTree)-1);
        left++;
      }
      globalMax = Math.max(globalMax, right - left + 1);
    }
    return globalMax;
  }
}
// @lc code=end
