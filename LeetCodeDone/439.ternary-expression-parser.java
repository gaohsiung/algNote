import java.util.*;

/*
 * @lc app=leetcode id=439 lang=java
 *
 * [439] Ternary Expression Parser
 */

// @lc code=start
class Solution {
    public String parseTernary(String expression) {
        // c.c.

        Stack<Character> stack = new Stack<>();
        int i = expression.length() - 1;
        boolean toEval = false;
        while(i >= 0) {
            char curChar = expression.charAt(i);
            if (curChar == '?') {
                toEval = true;
                i--;
            } else if (curChar >= '0' && curChar <= '9') {
                stack.push(curChar);
                i--;
            } else if (curChar == 'T' || curChar == 'F') {
                if (!toEval) {
                    stack.push(curChar);
                    i--;
                } else {
                    Character cond1 = stack.pop();
                    Character cond2 = stack.pop();
                    if (curChar == 'T') {
                        stack.push(cond1);
                    } else {
                        stack.push(cond2);
                    }
                    toEval = false;
                    i--;
                }
            } else {
                i--;
            }
        }
        return Character.toString(stack.peek());
        
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.parseTernary("T?T?F:5:3"));
    }
}
// @lc code=end

