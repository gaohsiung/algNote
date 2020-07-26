import java.util.*;

/*
 * @lc app=leetcode id=411 lang=java
 *
 * [411] Minimum Unique Word Abbreviation
 */

// @lc code=start
class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        Set<Integer> bitmaskSet = new HashSet<>();
        for(String s: dictionary) {
            if (s.length() != target.length()) continue;
            int curMask = 0;
            for(int i = 0; i < target.length(); i++) {
                curMask <<= 1;
                if (target.charAt(i) == s.charAt(i)) {
                    curMask |= 1;
                }
            }
            bitmaskSet.add(curMask);
        }
        int curIdx = 0;
        int path = 0;
        int curBitLength = 0;
        int[] res = new int[]{0, Integer.MAX_VALUE}; // store minlength bitmaskSet and the min value
        dfs(target, curIdx, path, curBitLength, bitmaskSet, res);
        // System.out.println(Integer.toBinaryString(res[0]));
        String ret = transfer(target, res);
        return ret;
    }

    private String transfer(String target, int[] res) {
        StringBuilder sb = new StringBuilder();
        int[] bits = new int[target.length()];
        for(int i = target.length() - 1; i >= 0 ;i--) {
            bits[i] = (res[0] & 1);
            res[0] >>= 1;
        }
        int count0 = 0;
        for(int i= 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                if (count0 != 0) {
                    sb.append(count0);
                }
                sb.append(target.charAt(i));
                count0 = 0;
            } else {
                count0++;
            }
        }
        if (count0 != 0) sb.append(count0);
        return sb.toString();
    }

    private void dfs(String target, int curIdx, int path, int curBitLength, Set<Integer> bitmaskSet, int[] res) {
        // base case
        if (curBitLength >= res[1]) { // len greater than the prev cases, pruning
            return;
        }
        if (curIdx == target.length()) { // parse done
            for(int mask: bitmaskSet) {
                if ((mask & path) == path) {
                    return;
                }
            }
            res[0] = path;
            res[1] = curBitLength;
            return;
        }
        // recursion
        // choose char
        dfs(target, curIdx+1, (path << 1)+1, curBitLength+1, bitmaskSet, res);
        // form a number
        for(int i = 1; i < target.length() - curIdx + 1; i++) {
            if (curBitLength == 0 || (path & 1) == 1) { // first or last time is char
                dfs(target, curIdx+i, path << i, curBitLength+1, bitmaskSet, res);
            }
        }

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minAbbreviation("apple", new String[]{"plain", "amber", "blade"});
    }
}
// @lc code=end

