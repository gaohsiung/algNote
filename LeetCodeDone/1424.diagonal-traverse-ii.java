import java.util.*;
/*
 * @lc app=leetcode id=1424 lang=java
 *
 * [1424] Diagonal Traverse II
 */

// @lc code=start
class Solution {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    // c.c.
    if (nums == null || nums.size() == 0 || nums.get(0) == null || nums.get(0).size() == 0) {
      return new int[]{};
    }

    int totalNum = 0;
    int maxIdxSum = 0;
    Map<Integer, List<Integer>> idxSumToValue = new HashMap<>();
    for(int r = nums.size() - 1; r >= 0; r--) {
      for(int c = 0; c < nums.get(r).size(); c++) {
        List<Integer> curList = idxSumToValue.getOrDefault(r+c, new ArrayList<>());
        curList.add(nums.get(r).get(c));
        idxSumToValue.put(r+c, curList);
        totalNum++;
        maxIdxSum = Math.max(maxIdxSum, r+c);
      }
    }

    int[] res = new int[totalNum];
    int i = 0;
    for (int idxSum = 0; idxSum <= maxIdxSum; idxSum++) {
      List<Integer> cur = idxSumToValue.get(idxSum);
      for(int n: cur) {
        res[i] = n;
        i++;
      }
    }
    return res;
  }
}
// @lc code=end
