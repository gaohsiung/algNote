import java.util.*;
/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
  TreeMap<Integer, Integer> bstMap;
  int range;
  public Solution(int[] w) {
    this.bstMap = new TreeMap<>();
    int sum = 0;
    for (int i = 0; i < w.length; i++) {
      if (w[i] <= 0) {
        throw new IllegalArgumentException();
      }
      sum += w[i];
      bstMap.put(sum, i);
    }
    this.range = sum;
  }

  public int pickIndex() {
    Random rand = new Random();
    int cur = rand.nextInt(this.range) + 1;
    return this.bstMap.ceilingEntry(cur).getValue();
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */
// @lc code=end
