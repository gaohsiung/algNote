import java.util.*;

/*
 * @lc app=leetcode id=294 lang=java
 *
 * [294] Flip Game II
 */

// @lc code=start
class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return dfs(s.toCharArray(), new HashMap<String, Boolean>());
    }

    private boolean dfs(char[] charArray, HashMap<String, Boolean> mem) {
        String curString = String.valueOf(charArray);
        if (mem.containsKey(curString)) {
            return mem.get(curString);
        }
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == '+' && charArray[i+1] == '+') {
                charArray[i] = '-';
                charArray[i+1] = '-';
                boolean ret = dfs(charArray, mem);
                charArray[i] = '+';
                charArray[i+1] = '+';
                if (!ret) {
                    mem.put(curString, true);
                    return true;
                }
            }
        }
        mem.put(curString, false);
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canWin("++++"));
    }
}
// @lc code=end

//back track before return/break the for loop!

