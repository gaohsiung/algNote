import java.util.*;
/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
  public boolean wordPattern(String pattern, String s) {
    Map<String, Integer> patternToCommonInt = new HashMap<>();
    Map<String, Integer> stringToCommonInt = new HashMap<>();
    String[] stringArr = s.split("\\s+");
    if (pattern.length() != stringArr.length) {
      return false;
    }
    int commonCount = 0;
    for (int i = 0; i < pattern.length(); i++) {
      String curPattern = String.valueOf(pattern.charAt(i));
      String curString = stringArr[i];
      if (patternToCommonInt.containsKey(curPattern) && stringToCommonInt.containsKey(curString)) {
        if (patternToCommonInt.get(curPattern) != stringToCommonInt.get(curString)) {
          return false;
        }
      } else if (patternToCommonInt.containsKey(curPattern) || stringToCommonInt.containsKey(curString)) {
        return false;
      } else {
        patternToCommonInt.put(curPattern, commonCount);
        stringToCommonInt.put(curString, commonCount);
        commonCount++;
      }
    }
    return true;

  }
}
// @lc code=end
