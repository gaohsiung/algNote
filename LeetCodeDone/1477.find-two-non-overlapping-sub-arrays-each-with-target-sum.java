import java.util.*;
/*
 * @lc app=leetcode id=1477 lang=java
 *
 * [1477] Find Two Non-overlapping Sub-arrays Each With Target Sum
 */

// @lc code=start
class Solution {
  public int minSumOfLengths(int[] arr, int target) {
    // c.c.
    Map<Integer, Integer> prefixSumToIdx = new HashMap<>();
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      prefixSumToIdx.put(sum, i);
    }
    prefixSumToIdx.put(0, -1);

    sum = 0;
    int leftLength = Integer.MAX_VALUE;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (prefixSumToIdx.containsKey(sum - target)) {
        leftLength = Math.min(leftLength, i - prefixSumToIdx.get(sum - target));
      }
      if (prefixSumToIdx.containsKey(sum + target) && leftLength != Integer.MAX_VALUE) {
        res = Math.min(res, leftLength + prefixSumToIdx.get(sum + target) - i);
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
// @lc code=end
