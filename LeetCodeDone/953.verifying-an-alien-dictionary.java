
import java.util.*;

/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> getIdxMap = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      getIdxMap.put(order.charAt(i), i);
    }
    for (int i = 0; i < words.length - 1; i++) {
      String firstString = words[i];
      String secondString = words[i+1];
      int compareRes = isFirstSmallerSecond(firstString, secondString, getIdxMap);
      if (compareRes == 1) {
        return false;
      }
    }
    return true;
  }
  private int isFirstSmallerSecond(String s1, String s2, Map<Character, Integer> map) {
    for (int i = 0; i < s1.length(); i++) {
      if (i >= s2.length()) {
        return 1;
      }
      if (map.get(s1.charAt(i)) < map.get(s2.charAt(i))) {
        return -1;
      } else if (map.get(s1.charAt(i)) > map.get(s2.charAt(i))) {
        return 1;
      }
    }
    return 0;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
  }
}
// @lc code=end
