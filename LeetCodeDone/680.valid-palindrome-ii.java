/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
  private boolean isRemoved = false;
  public boolean validPalindrome(String s) {
    return dfs(s, 0, s.length() - 1);
  }

  private boolean dfs(String s, int startIdx, int endIdx) {
    if (startIdx >= endIdx) {
      return true;
    }
    if (s.charAt(startIdx) == s.charAt(endIdx)) {
      return dfs(s, startIdx + 1, endIdx - 1);
    } else if (isRemoved) {
      return false;
    } else {
      isRemoved = true;
      boolean removeStartIdx = dfs(s, startIdx + 1, endIdx);
      boolean removeEndIdx = dfs(s, startIdx, endIdx - 1);
      return removeStartIdx || removeEndIdx;
    }
  }
}
// @lc code=end
