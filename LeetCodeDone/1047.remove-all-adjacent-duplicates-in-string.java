import java.util.*;
/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        // c.c.

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i++));
            } else if (stack.peek() == s.charAt(i)) {
                stack.pop();
                i++;
            } else if (stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i++));                
            }
        }


        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates("aaaaaa"));
    }
}
// @lc code=end

