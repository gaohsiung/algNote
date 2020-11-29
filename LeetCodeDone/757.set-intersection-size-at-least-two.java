import java.util.*;
/*
 * @lc app=leetcode id=757 lang=java
 *
 * [757] Set Intersection Size At Least Two
 */

// @lc code=start
class Solution {
  public int intersectionSizeTwo(int[][] intervals) {
    int[] counts = new int[intervals.length];
    int atLeast = 2;
    Arrays.sort(intervals, new Comparator<int[]>(){
      @Override
      public int compare(int[] itv1, int[] itv2) {
        if (itv1[0] != itv2[0]) {
          return itv1[0] - itv2[0];
        } else {
          return itv2[1] - itv1[1];
        }
      }
    });
    int res = 0;
    for (int i = intervals.length - 1; i >= 0; i--) {
      int start = intervals[i][0];
      for (int k = start; k < start+atLeast;k++) {
        if (counts[i] == atLeast) {
          break;
        }
        for (int j = 0; j < i; j++) {
          if (intervals[j][1] >= k) {
            counts[j] = Math.min(counts[j]+1, atLeast);
          }
        }
        counts[i]++;
        res++;
      }

    }
    return res;
  }
}
// @lc code=end
