import java.util.*;

/*
 * @lc app=leetcode id=291 lang=java
 *
 * [291] Word Pattern II
 */

// @lc code=start
class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() > str.length()) {
            return false;
        }
        return dfs(pattern, str, 0, 0, new HashMap<Character, String>(), new HashSet<String>());
    }

    private boolean dfs(String pattern, String str, int pIndex, int sIndex, 
                        HashMap<Character, String> map, HashSet<String> hasValue) {
        // success
        if (pIndex == pattern.length()) {
            return sIndex == str.length();
        }

        // existed pattern
        if(map.containsKey(pattern.charAt(pIndex))) {
            String mustMatchSub = map.get(pattern.charAt(pIndex));
            if (sIndex + mustMatchSub.length() <= str.length() 
                && str.substring(sIndex, sIndex + mustMatchSub.length()).equals(mustMatchSub)) {
                return dfs(pattern, str, pIndex+1, sIndex + mustMatchSub.length(), map, hasValue);
            } else {
                return false;
            }
        }
        // not existed pattern
        for (int i = sIndex + 1; i <= str.length(); i++) {
            String curVal = str.substring(sIndex, i);
            if (hasValue.contains(curVal)) continue;
            hasValue.add(curVal);
            map.put(pattern.charAt(pIndex), curVal);
            if (dfs(pattern, str, pIndex+1, i, map, hasValue)) {
                return true;
            }
            map.remove(pattern.charAt(pIndex), curVal);
            hasValue.remove(curVal);
        }

        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.wordPatternMatch("", "s"));
    }
}
// @lc code=end

