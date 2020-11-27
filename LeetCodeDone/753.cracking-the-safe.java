import java.util.*;
/*
 * @lc app=leetcode id=753 lang=java
 *
 * [753] Cracking the Safe
 */

// @lc code=start
class Solution {
  public String crackSafe(int n, int k) {
    Set<String> visited = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append('0');
    }
    visited.add(sb.toString());
    dfs(n, k, visited, sb);
    return sb.toString();
  }
  private boolean dfs(int n, int k, Set<String> visited, StringBuilder sb) {
    String last = sb.substring(sb.length() - n + 1, sb.length());
    for (int i = 0; i < k; i++) {
      String cur = last + String.valueOf(i);
      if (!visited.contains(cur)) {
        visited.add(cur);
        sb.append(i);
        if (visited.size() == (int) Math.pow(k, n)) {
          return true;
        }
        if (dfs(n, k, visited, sb)) {
          return true;
        }
        sb.setLength(sb.length() - 1);
        visited.remove(cur);
      }
    }
    return false;
  }
}
// @lc code=end
