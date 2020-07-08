import java.util.*;

/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfs(num, 0, target, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String num, int index, int target, long prevValue, 
        long curSum, StringBuilder path, List<String> res) {
        if (index == num.length() && target == curSum) {
            res.add(path.toString());
            return;
        }
        if (index >= num.length()) {
            return;
        }
        int pathLen = path.length();
        long curVal = 0;
        for(int i = index; i < num.length(); i++) {
            curVal = curVal * 10 + (num.charAt(i) - '0');
            if (index != 0) {
                // +
                path.append("+").append(curVal);
                dfs(num, i + 1, target, curVal, curSum + curVal, path, res);
                path.setLength(pathLen);
                // -
                path.append("-").append(curVal);
                dfs(num, i + 1, target, -curVal, curSum - curVal, path, res);
                path.setLength(pathLen);
                // x
                path.append("*").append(curVal);
                dfs(num, i + 1, target, prevValue * curVal, 
                    (curSum - prevValue) + prevValue * curVal, path, res);
                path.setLength(pathLen);
            } else {
                path.append(curVal);
                dfs(num, i + 1, target, curVal, curVal, path, res);
                path.setLength(pathLen);
            }
            if (curVal == 0) {
                break;
            }
        }   
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addOperators("1000000009", 9));
    }
}
// @lc code=end

