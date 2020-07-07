import java.util.*;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        char[][] numMap = new char[10][];
        numMap[0] = null;
        numMap[1] = null;
        numMap[2] = new char[]{'a','b', 'c'};
        numMap[3] = new char[]{'d','e', 'f'};
        numMap[4] = new char[]{'g','h', 'i'};
        numMap[5] = new char[]{'j','k', 'l'};
        numMap[6] = new char[]{'m','n', 'o'};
        numMap[7] = new char[]{'p','q', 'r', 's'};
        numMap[8] = new char[]{'t','u', 'v'};
        numMap[9] = new char[]{'w','x', 'y', 'z'};
        dfs(digits, 0, new StringBuilder(), res, numMap);
        return res;
        
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> res, char[][] numMap) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        if (index >= digits.length()) {
            return;
        }
        int curNumber = digits.charAt(index)-'0';
        if (curNumber == 0 || curNumber == 1) {
            return;
        }
        for(char c: numMap[curNumber]) {
            int size = sb.length();
            sb.append(c);
            dfs(digits, index+1, sb, res, numMap);
            sb.setLength(size);
        }

    }
}
// @lc code=end

