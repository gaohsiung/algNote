import java.util.*;
/*
 * @lc app=leetcode id=1400 lang=java
 *
 * [1400] Construct K Palindrome Strings
 */

// @lc code=start
class Solution {
  public boolean canConstruct(String s, int k) {
    // c.c.

    // e.c.
    if (s.length() < k) {
      return false;
    }
    Map<Character, Integer> counts = new HashMap<>();
    for (char c: s.toCharArray()) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }
    int oddNum = 0;
    for (int value: counts.values()) {
      if (value % 2 == 1) {
        oddNum++;
      }
    }
    return oddNum <= k;

  }
}
// @lc code=end
