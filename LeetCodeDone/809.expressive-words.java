/*
 * @lc app=leetcode id=809 lang=java
 *
 * [809] Expressive Words
 */

// @lc code=start
class Solution {
  public int expressiveWords(String s, String[] words) {
    // c.c.
    int count = 0;
    for (String word: words) {
      if (isStretchy(s, word)) {
        count++;
      }
    }
    return count;
  }
  private boolean isStretchy(String s1, String s2) {
    int p1 = 0;
    int p2 = 0;
    while (p1 < s1.length() && p2 < s2.length()) {
      if (s1.charAt(p1) != s2.charAt(p2)) {
        return false;
      }
      int p1RepeatValNo = getRepeatValNo(s1, p1);
      int p2RepeatValNo = getRepeatValNo(s2, p2);
      if ((p1RepeatValNo == 1 && p2RepeatValNo == 1) ||
        (p1RepeatValNo >= 3 && p2RepeatValNo == 1) ||
        (p1RepeatValNo >= p2RepeatValNo && p2RepeatValNo >= 2)
        ) {
          p1 += p1RepeatValNo;
          p2 += p2RepeatValNo;
      } else {
        return false;
      }
    }
    return p1 == s1.length() && p2 == s2.length();
  }
  private int getRepeatValNo(String s, int idx) {
    int count = 0;
    char curChar = s.charAt(idx);
    while (idx < s.length()) {
      if (s.charAt(idx) == curChar) {
        count++;
        idx++;
      } else {
        break;
      }
    }
    return count;
  }
}
// @lc code=end
