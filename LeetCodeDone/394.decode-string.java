import java.util.*;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        // c..c

        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int i = 0;
        strStack.push(new StringBuilder());
        while(i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') { // numbers
                int val = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    val = val*10 + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(val);
            } else if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') 
            || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                strStack.peek().append(s.charAt(i));
                i++;
            } else if (s.charAt(i) == '[') {
                strStack.push(new StringBuilder());
                i++;
            } else if (s.charAt(i) == ']') {
                String repString = strStack.pop().toString();
                int nums = numStack.pop();
                while(nums-- > 0) {
                    strStack.peek().append(repString.toString());
                }
                i++;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return strStack.peek().toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.decodeString("abc3[cd]xyz"));
    }
}
// @lc code=end

