import java.util.*;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        // c.c.

        Stack<String> stack = new Stack<>();
        stack.push("/");

        // add to stack
        int i = 0;
        while(i < path.length()) {
            if (path.charAt(i) != '/' && path.charAt(i) != '.') { // form folder name
                StringBuilder sb = new StringBuilder();
                while(i < path.length() && path.charAt(i) != '/') {
                    sb.append(path.charAt(i));
                    i++;
                }
                sb.append('/');
                stack.push(sb.toString());
            } else if (path.charAt(i) == '.') { // dot
                StringBuilder sb = new StringBuilder();
                while(i < path.length() && path.charAt(i) != '/') {
                    sb.append(path.charAt(i));
                    i++;
                }
                String cur = sb.toString();
                if (cur.equals(".")) {

                } else if (cur.equals("..")) {
                    if (!stack.peek().equals("/")) {
                        stack.pop();
                    }
                } else {
                    stack.push(cur+"/");
                }
            } else { // slash
                i++;
            }
        }
        // post processing
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        if (sb.length() == 1) return sb.toString();
        sb.setLength(sb.length() - 1); // remove last /
        return sb.toString();

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.simplifyPath("/..."));
    }
}
// @lc code=end

