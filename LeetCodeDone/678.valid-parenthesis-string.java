/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
  public boolean checkValidString(String s) {
    // c.c.
    Boolean[][] mem = new Boolean[s.length()][s.length()];
    return dfs(s, 0, 0, mem);
  }
  private boolean dfs(String s, int idx, int leftCount, Boolean[][] mem) {
    if (leftCount < 0) {
      return false;
    }
    if (leftCount == 0 && idx == s.length()) {
      return true;
    }
    if (idx == s.length()) {
      return false;
    }
    if (mem[idx][leftCount] != null) {
      return mem[idx][leftCount];
    }
    if (s.charAt(idx) == '(') {
      mem[idx][leftCount] = dfs(s, idx+1, leftCount+1, mem);
    } else if (s.charAt(idx) == ')') {
      mem[idx][leftCount] = dfs(s, idx+1, leftCount-1, mem);
    } else if (s.charAt(idx) == '*') {
      if (dfs(s, idx+1, leftCount+1, mem) || dfs(s, idx+1, leftCount-1, mem) || dfs(s, idx+1, leftCount, mem)) {
        mem[idx][leftCount] = true;
      } else {
        mem[idx][leftCount] = false;
      }
    }
    return mem[idx][leftCount];

  }
}
// @lc code=end
