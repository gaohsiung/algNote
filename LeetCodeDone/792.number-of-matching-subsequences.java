import java.util.*;
/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 */

// @lc code=start
class Solution { //  O(S.length+∑iwords[i].length)
  public int numMatchingSubseq(String str, String[] words) {
    Map<Character, List<String>> countMap = new HashMap<>();
    for (String s: words) {
      process(countMap, s);
    }
    int res = 0;
    for (char c: str.toCharArray()) {
      if (!countMap.containsKey(c)) {
        continue;
      }
      List<String> oldList = countMap.get(c);
      countMap.remove(c);
      for (String s: oldList) {
        if (s.equals("")) {
          res++;
          continue;
        }
        process(countMap, s);        
      }
    }
    return res;
  }
  private void process(Map<Character, List<String>> countMap, String s) {
    if (!countMap.containsKey(s.charAt(0))) {
      countMap.put(s.charAt(0), new ArrayList<>());
    }
    if (s.length() == 1) {
      countMap.get(s.charAt(0)).add("");
    } else {
      countMap.get(s.charAt(0)).add(s.substring(1));
    }
  }
}
// @lc code=end
