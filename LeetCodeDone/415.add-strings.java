
/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
  public String addStrings(String num1, String num2) {
    // c.c.
    if (num1.length() < num2.length()) { // make sure num1 longer than num2
      return addStrings(num2, num1);
    }
    int len1 = num1.length();
    int len2 = num2.length();
    boolean isCarry = false;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len2; i++) {
      int v1 = num1.charAt(len1 - 1 - i) - '0';
      int v2 = num2.charAt(len2 - 1 - i) - '0';
      int res;
      if (isCarry) {
        res = v1+v2+1;
      } else {
        res = v1+v2;
      }
      if (res >= 10) {
        isCarry = true;
      } else {
        isCarry = false;
      }
      sb.append(Integer.toString(res%10));
    }
    for (int i = len1-len2-1; i >= 0; i--) {
      int v = num1.charAt(i) - '0';
      int res;
      if (isCarry) {
        res = v+1;
      } else {
        res = v;
      }
      if (res >= 10) {
        isCarry = true;
      } else {
        isCarry = false;
      }
      sb.append(Integer.toString(res%10));
    }
    if (isCarry) sb.append("1");
    return sb.reverse().toString();
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.addStrings("999", "9999"));
  }
}
// @lc code=end
