import java.util.*;
/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
  public int maxPoints(int[][] points) {
    if (points.length <= 2) {
      return points.length;
    }
    Map<Slope, Integer> counts;
    int max = 0;
    for (int i = 0; i < points.length; i++) {
      counts = new HashMap<>();
      int dups = 1;
      for (int j = i+1; j < points.length; j++) {
        if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
          dups++;
          continue;
        }
        int dx = points[i][0] - points[j][0];
        int dy = points[i][1] - points[j][1];
        Slope curSlope;
        if (dx == 0) {
          curSlope = new Slope(0, 1);
        } else if (dy == 0) {
          curSlope = new Slope(1, 0);
        } else {
          int gcd = getGCD(dx, dy);
          dx = dx/gcd;
          dy = dy/gcd;
          curSlope = new Slope(dx, dy);
        }
        counts.put(curSlope, counts.getOrDefault(curSlope, 0) + 1);
      }
      max = Math.max(max, dups);
      for (int value: counts.values()) {
        max = Math.max(max, dups + value);
      }
    }
    return max;
  }
  private int getGCD(int i1, int i2) {
    if (i2 == 0) return i1;
    return getGCD(i2, i1 % i2);
  }

  private static class Slope {
    private int dx;
    private int dy;
    private Slope(int dx, int dy) {
      this.dx = dx;
      this.dy = dy;
    }
    @Override
    public int hashCode() {
      return this.dx ^ this.dy;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) {
        return false;
      }
      if (!(o instanceof Slope)) {
        return false;
      }
      Slope that = (Slope) o;
      return (this.dx == that.dx) && (this.dy == that.dy);
    }
  }
}
// @lc code=end
