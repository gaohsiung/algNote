import java.util.*;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        int[] findMinRemove = findMinRePar(s);
        int delL = findMinRemove[0];
        int delR = findMinRemove[1];
        dfs(s, new StringBuilder(), res, delL, delR, 0, 0);
        return res;
    }

    private void dfs(String s, StringBuilder sb, List<String> res, 
        int delL, int delR, int index, int delta) {
        if(index == s.length() && delL == 0 && delR == 0 && delta == 0) {
            res.add(sb.toString());
            return;
        }
        if(index == s.length() || delL < 0 || delR < 0 || delta < 0) {
            return;
        }

        char c = s.charAt(index);
        int initialIndex = index;
        int oldSbLength = sb.length();
        index++;
        if (c == '(') {
            dfs(s, sb, res, delL - 1, delR, index, delta);
            while(index < s.length() && s.charAt(index) == '(') {
                index++;
            }
            sb.append(s, initialIndex, index);
            dfs(s, sb, res, delL, delR, index, delta+(index - initialIndex));
            sb.setLength(oldSbLength);
        } else if (c == ')') {
            dfs(s, sb, res, delL, delR - 1, index, delta);
            while(index < s.length() && s.charAt(index) == ')') {
                index++;
            }
            
            sb.append(s, initialIndex, index);
            dfs(s, sb, res, delL, delR, index, delta-(index - initialIndex));
            sb.setLength(oldSbLength);
        } else {
            sb.append(c);
            dfs(s, sb, res, delL, delR, index, delta);
            sb.setLength(oldSbLength);
        }

    }

    private int[] findMinRePar(String s) {
        int removeLeft = 0;
        int removeRight = 0;
        for(char c: s.toCharArray()) {
            if (c == '(') {
                removeLeft++;
            } else if (c == ')') {
                if (removeLeft > 0) {
                    removeLeft--;
                } else {
                    removeRight++;
                }
            }
        }
        return new int[]{removeLeft, removeRight};
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeInvalidParentheses("()())()"));
    }
}
// @lc code=end
// 任取一个删法答案：
// 从左往右扫，删右括号；从右往左扫，删左括号
