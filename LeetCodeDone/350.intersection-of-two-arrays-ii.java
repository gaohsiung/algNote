import java.util.*;
/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return intersect(nums2, nums1);
    }
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i: nums1) {
      countMap.put(i, countMap.getOrDefault(i, 0) + 1);
    }
    List<Integer> res = new ArrayList<>();
    for (int i: nums2) {
      if (countMap.containsKey(i) && countMap.get(i) > 0) {
        res.add(i);
        countMap.put(i, countMap.get(i) - 1);
      }
    }
    int[] ret = new int[res.size()];
    for (int i = 0; i < ret.length; i++) {
      ret[i] = res.get(i);
    }
    return ret;
  }
}
// @lc code=end
