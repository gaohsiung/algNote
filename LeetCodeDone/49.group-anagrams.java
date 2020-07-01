import java.util.*;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] single = new char[26];
            for (int j = 0; j < strs[i].length(); j++) {
                single[strs[i].charAt(j) - 'a']++;
            }
            String key = new String(single);
            if (!map.containsKey(key)) {
                List<String> value = new LinkedList<String>();
                map.put(key, value);
            }
            map.get(key).add(strs[i]);
        }
        for (String key: map.keySet()) {
            res.add(map.get(key));
        }
        return res;

    }
}
// @lc code=end

