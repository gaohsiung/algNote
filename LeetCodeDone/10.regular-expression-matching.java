/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        return dfs(s, 0, p, 0, new Boolean[s.length()+1][p.length()]);
    }
    private boolean dfs(String s, int sIdx, String p, int pIdx, Boolean[][] mem) {
        if (pIdx == p.length()) {
            return s.length() == sIdx;
        }
        if (mem[sIdx][pIdx] != null) {
            return mem[sIdx][pIdx];
        }
        boolean ret = false;
        if(pIdx == p.length() - 1 || p.charAt(pIdx + 1) != '*') {
            if (sIdx < s.length() && isMatchChar(s.charAt(sIdx), p.charAt(pIdx))) {
                ret = dfs(s, sIdx+1, p, pIdx+1, mem);
            }
        } else {
            int nextSIdx = sIdx - 1;
            while(nextSIdx < s.length()) {
                if (nextSIdx < sIdx) {
                    ret = dfs(s, nextSIdx + 1, p, pIdx+2, mem);
                    if (ret) {
                        break;
                    }
                } else {
                    if (isMatchChar(s.charAt(nextSIdx), p.charAt(pIdx))) {
                        ret = dfs(s, nextSIdx + 1, p, pIdx + 2, mem);
                        if (ret) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                nextSIdx++;
            }
        }
        mem[sIdx][pIdx] = ret;
        return ret;

    }

    
    private boolean isMatchChar(char cFromS, char cFromP) {
        if (cFromP == '.') {
            return true;
        } else {
            return cFromS == cFromP;
        }

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("ab",".*c"));
    }
}
// @lc code=end


