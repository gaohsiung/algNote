import java.util.*;

/*
 * @lc app=leetcode id=388 lang=java
 *
 * [388] Longest Absolute File Path
 */

// @lc code=start
class Solution {
    public int lengthLongestPath(String input) {
        // c.c.
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int level = 0;
        int max = 0;
        int curLen = 0;
        while(i < input.length()) {
            // notice contains space !!!
            if (input.charAt(i) == ' ' || input.charAt(i) == '.' || (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')|| (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) { // root
                curLen = 0;
                boolean isFile = false;
                while(i < input.length() && input.charAt(i) != '\n') {
                    if (input.charAt(i) == '.') {
                        isFile = true;
                    }
                    curLen++;
                    i++;
                }
                while(stack.size() > level) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    if (isFile) {
                        max = Math.max(max, curLen);
                    } else {
                        stack.push(curLen+1);
                    }
                } else {
                    if (isFile){
                        max = Math.max(max, stack.peek()+curLen);
                    } else {
                        stack.push(stack.peek()+curLen+1);
                    }
                }
                if (i == input.length()) { // reach end
                    break;
                }
            } else if (input.charAt(i) == '\n') {
                level = 0;
                i++;
            } else if (input.charAt(i) == '\t') { // start with \t
                level = 0;
                while(i < input.length() && input.charAt(i) == '\t') { // count \t
                    level++;
                    i += 1;
                }
            } else {
                i++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthLongestPath("dir\n  file.txt"));
    }
}
// @lc code=end

