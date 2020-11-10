import java.util.*;
/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return "";
    }
    List<String> strList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      strList.add(String.valueOf(nums[i]));
    }
    Collections.sort(strList, new Comparator<String>(){
      @Override
      public int compare(String s1, String s2) {
        return (s2+s1).compareTo(s1+s2);
      }
    });
    if (strList.get(0).charAt(0) == '0') {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    for(String s: strList) {
      sb.append(s);
    }
    return sb.toString();
  }
}
// @lc code=end
