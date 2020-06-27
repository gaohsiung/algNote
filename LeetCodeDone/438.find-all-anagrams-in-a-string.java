import java.util.*;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || p == null) {
            return res;
        }
        int[] charMap = new int[256];
        for (char c: p.toCharArray()) {
            charMap[c] ++;
        }
        int slow = 0;
        int fast = 0;
        int window = 0;
        while (fast < s.length()) {
            if (charMap[s.charAt(fast)] > 0) {
                window++;
            }
            charMap[s.charAt(fast)]--;
            fast++;
            
            if (window == p.length()) {
                res.add(slow);
            }
            if (fast - slow == p.length()) {
                if (charMap[s.charAt(slow)] >= 0) {
                    window--;
                }
                charMap[s.charAt(slow)]++;
                slow++;
            }
        }
        return res;

        
        

        
    }
    public static void main(String[] ss){
        Solution sol = new Solution();
        System.out.println(sol.findAnagrams("cbaebabacd", "abc"));
    }
}
// @lc code=end

// int[] hash = new int[256];
//         for (char c: p.toCharArray()) {
//             hash[c]++;
//         }
//         int slow = 0;
//         int fast = 0;
//         int length = 0;
//         while (fast < s.length()) {
//             if (hash[s.charAt(fast)] > 0) {
//                 length++;
//             }
//             hash[s.charAt(fast)]--;
//             fast++;
//             if (length == p.length()) {
//                 res.add(slow);
//             }
//             if (fast - slow == p.length()) {
//                 if (hash[s.charAt(slow)] >= 0) {
//                     length--;
//                 }
//                 hash[s.charAt(slow)]++;
//                 slow++;
//             }

//         }
//         return res;
