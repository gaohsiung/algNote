import java.util.*;
/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
  public boolean backspaceCompare(String s, String t) {
    String newS = process(s);
    String newT = process(t);
    return newS.equals(newT);
  }
  private String process(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '#') {
        stack.push(s.charAt(i));
      } else if (!stack.isEmpty()) {
        stack.pop();
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    sb.reverse();
    return sb.toString();
  }
}
// @lc code=end
