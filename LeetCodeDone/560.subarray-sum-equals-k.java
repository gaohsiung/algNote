import java.util.*;
/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
  public int subarraySum(int[] nums, int k) {
    int sum = 0;
    int res = 0;
    Map<Integer, Integer> cumulativeSumToFrequency = new HashMap<>();
    cumulativeSumToFrequency.put(0, 1); // zero means find one

    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (cumulativeSumToFrequency.containsKey(sum - k)) {
        res += cumulativeSumToFrequency.get(sum-k);
      }
      cumulativeSumToFrequency.put(sum, cumulativeSumToFrequency.getOrDefault(sum, 0) + 1);
    }
    return res;
  }
}
// @lc code=end
//
// bad brutal force
// class Solution {
//   public int subarraySum(int[] nums, int k) {
//     int[] cumulativeSum = new int[nums.length];
//     int sum = 0;
//     for (int i = 0; i < nums.length; i++) {
//       sum += nums[i];
//       cumulativeSum[i] = sum;
//     }
//     int res = 0;
//     for(int i = 0; i < nums.length; i++) {
//       for (int j = i; j < nums.length; j++) {
//         if (cumulativeSum[j] - cumulativeSum[i] + nums[i] == k) {
//           res++;
//         }
//       }
//     }
//     return res;
//   }
// }