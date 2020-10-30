/*
 * @lc app=leetcode id=829 lang=java
 *
 * [829] Consecutive Numbers Sum
 */

// @lc code=start
class Solution {
  public int consecutiveNumbersSum(int N) {
    // N = k + (k+1) + (k+2) + ... + (k + (i-1))
    // N = k*i + (0 + 1 + 2 + ... + i-1)
    // N = k*i + (i-1)*i / 2;
    // k = 0 --> max
    int res = 0;
    for (int i = 1; (i-1)*i/2 < N; i++) {
      if ((N - (i-1)*i/2) % i == 0) {
        res++;
      }
    }
    return res;
  }
}
// @lc code=end
