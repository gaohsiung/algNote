import java.util.*;
/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
  public String reorganizeString(String s) {
    // c.c.
    Map<Integer, Integer> counts = new HashMap<>();
    for (char c : s.toCharArray()) {
      counts.put(c - 'a', counts.getOrDefault(c - 'a', 0) + 1);
    }
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] ia1, int[] ia2) {
        return ia2[1] - ia1[1];
      }
    });
    for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
      maxHeap.offer(new int[] { e.getKey(), e.getValue() });
    }
    int[] prev = maxHeap.poll();
    StringBuilder sb = new StringBuilder();
    sb.append((char) ('a' + prev[0]));
    prev[1] -= 1;
    while (!maxHeap.isEmpty()) {
      int[] cur = maxHeap.poll();
      sb.append((char) ('a' + cur[0]));
      cur[1] -= 1;
      if (prev[1] > 0) {
        maxHeap.offer(prev);
      }
      prev = cur;
    }
    if (prev[1] > 0) {
      return "";
    }
    return sb.toString();
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.reorganizeString("aaab"));
  }

}
// @lc code=end
