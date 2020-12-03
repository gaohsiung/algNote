import java.util.*;
/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */

// @lc code=start
class Solution {
  public int subarraysDivByK(int[] arr, int k) {
    Map<Integer, Integer> counts = new HashMap<>();
    counts.put(0, 1);
    int res = 0;
    int sum = 0;
    for (int i: arr) {
      sum += i;
      sum = sum % k;
      if (sum < 0) sum += k;
      if (counts.containsKey(sum)) {
        res += counts.get(sum);
      }
      counts.put(sum, counts.getOrDefault(sum, 0) + 1);
    }
    return res;
  }
}
// @lc code=end
