import java.util.*;
/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
  public boolean isHappy(int n) {
    if (n <= 0) {
      return false;
    }
    Set<Integer> visited = new HashSet<>();
    int cur = n;
    while (!visited.contains(cur)) {
      if (cur == 1) {
        return true;
      }
      visited.add(cur);
      cur = calculateSquares(cur);
    }
    return false;
  }
  private int calculateSquares(int n) {
    int sum = 0;
    while (n != 0) {
      sum += (n % 10) * (n % 10);
      n /= 10;
    }
    return sum;
  }
}
// @lc code=end
