import java.util.*;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Character, Integer> charToInt = new HashMap<>();
        charToInt.put('A', 0);
        charToInt.put('G', 1);
        charToInt.put('C', 2);
        charToInt.put('T', 3);
        int window = 0;
        for(int i = 0; i < s.length(); i++) {
            window = ((window << 2) & ((1 << 20) - 1)) + charToInt.get(s.charAt(i));
            if (i < 9) continue;
            Boolean curStatus = visited.get(window);
            if (curStatus == null) { // first seen
                visited.put(window, false);
            } else if (!curStatus) { // false, second seen
                visited.put(window, true);
                res.add(s.substring(i-9, i+1));
            } else { // third seen
                continue;
            }
        }
        return res;
    }
}
// @lc code=end

