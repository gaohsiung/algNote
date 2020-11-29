import java.util.Arrays;

/*
 * @lc app=leetcode id=836 lang=java
 *
 * [836] Rectangle Overlap
 */

// @lc code=start
class Solution {
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    // e.c.
    if (!validate(rec1)) return false;
    if (!validate(rec2)) return false;
    int[][] interval1 = getInteval(rec1);
    int[][] interval2 = getInteval(rec2);
    if (overlap(interval1[0], interval2[0]) && overlap(interval1[1], interval2[1])) {
      return true;
    }
    return false;

  }
  private boolean overlap(int[] itv1, int[] itv2) {

    if (itv1[0] > itv2[0]) {
      return overlap(itv2, itv1);
    }
    return itv1[1] > itv2[0];
  }
  private boolean validate(int[] rec) {
    if (rec[0] == rec[2] || rec[1] == rec[3]) {
      return false;
    }
    return true;
  }
  private int[][] getInteval(int[] rec) {
    int[] itvX = new int[]{rec[0], rec[2]};
    int[] itvY = new int[]{rec[1], rec[3]};
    Arrays.sort(itvX);
    Arrays.sort(itvY);
    return new int[][]{itvX, itvY};
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.isRectangleOverlap(new int[]{-1,0,1,1}, new int[]{0,-1,0,1});
  }
}
// @lc code=end
