/*
 * @lc app=leetcode id=777 lang=java
 *
 * [777] Swap Adjacent in LR String
 */

// @lc code=start
class Solution {
  public boolean canTransform(String start, String end) {
    int startIdx = 0;
    int endIdx = 0;
    while (startIdx < start.length() && endIdx < end.length()) {
      while (startIdx < start.length() && start.charAt(startIdx) == 'X') {
        startIdx++;
      }
      while (endIdx < end.length() && end.charAt(endIdx) == 'X') {
        endIdx++;
      }
      if (startIdx == start.length() && endIdx == end.length()) {
        return true;
      }
      if (startIdx == start.length() || endIdx == end.length()) {
        break;
      }
      if (start.charAt(startIdx) != end.charAt(endIdx)) {
        return false;
      }
      if (start.charAt(startIdx) == 'L' && startIdx < endIdx) {
        return false;
      }
      if (start.charAt(startIdx) == 'R' && startIdx > endIdx) {
        return false;
      }
      startIdx++;
      endIdx++;
    }
    String postStringToCheck;
    int postIdx;
    if (startIdx == start.length()) {
      postStringToCheck = end;
      postIdx = endIdx;
    } else {
      postStringToCheck = start;
      postIdx = startIdx;
    }
    while (postIdx < postStringToCheck.length()) {
      if (postStringToCheck.charAt(postIdx) != 'X') {
        return false;
      }
      postIdx++;
    }
    return true;
  }
}
// @lc code=end
