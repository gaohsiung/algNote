/*
 * @lc app=leetcode id=223 lang=java
 *
 * [223] Rectangle Area
 */

// @lc code=start
class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int twoSumArea = getTwoSumArea(A,B,C,D,E,F,G,H);
    int[] horizontalInterval = findOverlapInterval(A, C, E, G);
    int[] verticalInterval = findOverlapInterval(B, D, F, H);
    if (horizontalInterval != null && verticalInterval != null) {
      return twoSumArea - (horizontalInterval[1] - horizontalInterval[0]) * (verticalInterval[1] - verticalInterval[0]);
    }
    return twoSumArea;
  }
  private int[] findOverlapInterval(int a1, int a2, int b1, int b2) { // [a1, a2] intersect with [b1, b2]
    if (a1 > b1) { // make sure a1 < b1
      return findOverlapInterval(b1, b2, a1, a2);
    }
    if (b1 >= a2) {
      return null;
    } else {
      return new int[]{b1, Math.min(a2, b2)};
    }

  }

  private int getTwoSumArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    return (C-A)*(D-B)+(G-E)*(H-F);
  }
}
// @lc code=end
