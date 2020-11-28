import java.util.*;
/*
 * @lc app=leetcode id=1481 lang=java
 *
 * [1481] Least Number of Unique Integers after K Removals
 */

// @lc code=start
class Solution { // Time: O(nlogn), space: O(n)
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    if (k == arr.length) {
      return 0;
    }
    Map<Integer, Integer> counts = new HashMap<>();
    int uniqueNo = 0;
    for (int i: arr) {
      if (!counts.containsKey(i)) {
        uniqueNo++;
      }
      counts.put(i, counts.getOrDefault(i, 0) + 1);
    }
    TreeMap<Integer, List<Integer>> reverseCounts = new TreeMap<>();
    for (Map.Entry<Integer, Integer> e: counts.entrySet()) {
      if (!reverseCounts.containsKey(e.getValue())) {
        reverseCounts.put(e.getValue(), new ArrayList<>());
      }
      reverseCounts.get(e.getValue()).add(e.getKey());
    }
    while (k > 0) {
      int minCount = reverseCounts.firstKey();
      if (minCount > k) {
        break;
      }
      k = k - minCount;
      uniqueNo--;
      reverseCounts.get(minCount).remove(reverseCounts.get(minCount).size() - 1);
      if (reverseCounts.get(minCount).size() == 0) {
        reverseCounts.remove(minCount);
      }
    }
    return uniqueNo;
  }
}
// @lc code=end
