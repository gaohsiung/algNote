import java.util.*;
/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 */

// @lc code=start
class Solution {
  public int balancedString(String s) {
    // c.c.
    int len = s.length();
    Map<Character, Integer> counts = new HashMap<>();
    for (char c: s.toCharArray()) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }
    counts.put('Q', counts.getOrDefault('Q', 0) - len/4);
    counts.put('W', counts.getOrDefault('W', 0) - len/4);
    counts.put('E', counts.getOrDefault('E', 0) - len/4);
    counts.put('R', counts.getOrDefault('R', 0) - len/4);
    
    if (counts.get('Q') == 0 && counts.get('W') == 0 &&
    counts.get('E') == 0 && counts.get('R') == 0) {
      return 0;
    }
    int left = 0;
    int globalMin = s.length();
    for (int right = 0; right < len; right++) {
      char curChar = s.charAt(right);
      counts.put(curChar, counts.get(curChar) - 1);
      while (counts.get('Q') <= 0 && counts.get('W') <= 0 && counts.get('E') <= 0 && counts.get('R') <= 0) {
        globalMin = Math.min(globalMin, right - left + 1);
        char leftChar = s.charAt(left);
        counts.put(leftChar, counts.get(leftChar) + 1);
        left++;
      }
    }
    return globalMin;
    
  }

}
// @lc code=end
