import java.util.*;
/*
 * @lc app=leetcode id=1190 lang=java
 *
 * [1190] Reverse Substrings Between Each Pair of Parentheses
 */

// @lc code=start
class Solution {
  public String reverseParentheses(String s) {
    // c.c.

    Deque<StringBuilder> stack = new ArrayDeque<>();
    stack.push(new StringBuilder());
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(new StringBuilder());
        i++;
      } else if (c == ')') {
        StringBuilder temp = stack.pop().reverse();
        stack.peek().append(temp);
        i++;
      } else {
        while (i < s.length() && s.charAt(i) != ')' && s.charAt(i) != '(') {
          stack.peek().append(s.charAt(i++));
        }
      }
    }
    return stack.pop().toString();

  }
}
// @lc code=end
