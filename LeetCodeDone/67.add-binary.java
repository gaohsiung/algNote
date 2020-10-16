/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
  public String addBinary(String a, String b) {
    if (a.length() > b.length()) return addBinary(b, a);
    int diff = b.length() - a.length();
    while(diff-- > 0) {
      a = "0" + a;
    }

    int aPointer = a.length() - 1;
    int bPointer = b.length() - 1;

    StringBuilder sb = new StringBuilder();
    boolean isCarry = false;
    while (aPointer >= 0 && bPointer >= 0) {
      if (!isCarry) {
        if (a.charAt(aPointer) == '1' && b.charAt(bPointer) == '1') {
          sb.append("0");
          isCarry = true;
        } else if (a.charAt(aPointer) == '1' || b.charAt(bPointer) == '1') {
          sb.append("1");
          isCarry = false;
        } else {
          sb.append("0");
          isCarry = false;
        }
      } else {
        if (a.charAt(aPointer) == '1' && b.charAt(bPointer) == '1') {
          sb.append("1");
          isCarry = true;
        } else if (a.charAt(aPointer) == '1' || b.charAt(bPointer) == '1') {
          sb.append("0");
          isCarry = true;
        } else {
          sb.append("1");
          isCarry = false;
        }
      }
      aPointer--;
      bPointer--;
    }
    if (isCarry) sb.append("1");

    return sb.reverse().toString();
  }
}
// @lc code=end
