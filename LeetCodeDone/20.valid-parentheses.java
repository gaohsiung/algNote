import java.util.*;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
                continue;
            }
            if (stack.isEmpty() || !isMatch(stack.peek(), cur)) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty()? true:false;
    }

    private boolean isMatch(Character left, char right) {
        if (left == '(' && right == ')' ||
        left == '[' && right == ']' ||
        left == '{' && right == '}') {
            return true;
        }
        return false;
    }
}
// @lc code=end

