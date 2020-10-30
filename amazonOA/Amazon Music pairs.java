/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
  public int numPairsDivisibleBy60(int[] time) {
    int c[] = new int[60], res = 0;
    for (int t : time) {
      res += c[(600 - t) % 60];
      c[t % 60] += 1;
    }
    return res;
  }
}
// @lc code=end
