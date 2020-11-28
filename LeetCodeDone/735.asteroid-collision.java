import java.util.*;
/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();
    int idx = 0;
    while (idx < asteroids.length) {
      int cur = asteroids[idx];
      if (stack.isEmpty() || stack.peek() * cur > 0 || (stack.peek() < 0 && cur > 0)) {
        stack.push(cur);
        idx++;
        continue;
      }
      if (Math.abs(stack.peek()) > Math.abs(cur)) {
        idx++;
      } else if (Math.abs(stack.peek()) < Math.abs(cur)) {
        stack.pop();
      } else {
        stack.pop();
        idx++;
      }
    }
    int[] res = new int[stack.size()];
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = stack.pop();
    }
    return res;
  }
}
// @lc code=end
