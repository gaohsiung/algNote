import java.util.*;
/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 */

// @lc code=start
class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> res = new ArrayList<>();
    if (n <= 0) {
      return res;
    }
    for (int i = 1; i <= 9; i++) {
      dfs(i, n, res);
    }
    return res;
  }
  private void dfs(int prev, int n, List<Integer> res) {
    if (prev > n) {
      return;
    }
    res.add(prev);
    int cur = prev;
    for (int i = 0; i <= 9; i++) {
      cur = prev * 10 + i;
      dfs(cur, n, res);
    }
  }
}
// @lc code=end
