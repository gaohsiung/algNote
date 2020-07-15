import java.util.*;

/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new LinkedList<Integer>();
        }
        return dfs(input, 0, input.length() - 1);
    }

    private List<Integer> dfs(String input, int start, int end) {
        boolean isNum = true;
        List<Integer> res = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                isNum = false;
                List<Integer> lefts = dfs(input, start, i-1);
                List<Integer> rights = dfs(input, i+1, end);
                for (int l: lefts) {
                    for (int r: rights) {
                        res.add(calculate(l, r, input.charAt(i)));
                    }
                }


            }
        }
        if (isNum) {
            List<Integer> leaf = new LinkedList<>();
            leaf.add(Integer.valueOf(input.substring(start, end+1)));
            return leaf;
        }
        return res;
    }
    
    private Integer calculate(int l, int r, char optr) {
        if (optr == '+') return l+r;
        if (optr == '-') return l-r;
        if (optr == '*') return l*r;
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println();
    }
}
// @lc code=end

