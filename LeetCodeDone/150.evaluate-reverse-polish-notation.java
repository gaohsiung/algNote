import java.util.*;
/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String s: tokens) {
            if (isOperator(s)) {
                int val2 = numStack.pop();
                int val1 = numStack.pop();
                numStack.push(calculate(val1, val2, s));
            } else {
                numStack.push(Integer.parseInt(s));
            }
        }
        return numStack.pop();
    }
    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
    private int calculate(int val1, int val2, String optr) {
        if (optr.equals("+")) {
            return val1 + val2;
        }
        if (optr.equals("-")) {
            return val1 - val2;
        }
        if (optr.equals("*")) {
            return val1 * val2;
        }
        if (optr.equals("/")) {
            return val1 / val2;
        }
        throw new IllegalArgumentException();
    }
}
// @lc code=end

