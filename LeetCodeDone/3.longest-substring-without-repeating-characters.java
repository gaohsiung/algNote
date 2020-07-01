import java.util.*;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[256];
        int left = 0;
        int right = 0;
        int repNo = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if (map[s.charAt(right)] == 1) {
                repNo++;
            }
            map[s.charAt(right)]++;
            right++;
            while(repNo > 0) {
                if (map[s.charAt(left)] == 2) {
                    repNo--;
                }
                map[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left);

        }
        return maxLen;
    }
}
// @lc code=end
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         int slow = 0;
//         int fast = 0;
//         int maxLength = 0;
//         Map<Character, Integer> map = new HashMap<>();
//         for (fast = 0; fast < s.length(); fast++) {
//             char curChar = s.charAt(fast);
//             if (map.containsKey(curChar)) {
//                 int lastIndex = map.get(curChar);
//                 if (lastIndex >= slow) {
//                     slow = lastIndex + 1;
//                 }
//             }
//             map.put(curChar, fast);
//             maxLength = Math.max(maxLength, fast - slow + 1);
            
//         }
//         return maxLength;
//     }
// }
