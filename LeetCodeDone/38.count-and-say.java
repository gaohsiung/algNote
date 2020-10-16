import java.util.*;
/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    String prevCount = countAndSay(n - 1);

    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < prevCount.length()) {
      int countRep = 1;
      char curChar = prevCount.charAt(i);
      while(i+1 < prevCount.length() && prevCount.charAt(i) == prevCount.charAt(i+1)) {
        countRep++;
        i++;
      }
      sb.append(countRep);
      sb.append(curChar);
      i++;
    }
    return sb.toString();

  }
}
// @lc code=end
