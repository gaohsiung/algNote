/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 */

// @lc code=start
class Solution {
  public int numberOfSubstrings(String s) {
    int[] counts = new int[3];

    int res = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      counts[s.charAt(right)-'a'] += 1;
      while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
        res += s.length() - right;
        counts[s.charAt(left) - 'a'] -= 1;
        left++;
      }
    }
    return res;
  }
}
// @lc code=end
