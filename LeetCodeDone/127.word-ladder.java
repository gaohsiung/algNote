import java.util.*;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> dict = new HashSet<>();
        for (String s: wordList) {
            dict.add(s);
        }
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> edgeCase = new HashSet<>();
        edgeCase.add(endWord);
        if (transform(edgeCase, beginWord).size() > 0) {
            return 2;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        dict.remove(beginWord);
        dict.remove(endWord);

        int minLen = 1;
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set1.size() > set2.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            Set<String> nextLevelSet = new HashSet<>();
            for(String s: set1) {
                List<String> nexts = transform(dict, s);
                for(String next: nexts) {
                    if (transform(set2, next).size() > 0) {
                        return minLen + 2;
                    }
                    nextLevelSet.add(next);
                    dict.remove(next);
                }
            }
            set1 = nextLevelSet;
            minLen++;
        }
        return 0;
    }

    private List<String> transform(Set<String> wordList, String cur) {
        List<String> res = new LinkedList<>();
        char[] charCur = cur.toCharArray();
        for (int i = 0; i < charCur.length; i++) {
            char temp = charCur[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charCur[i] = c;
                String newString = new String(charCur);
                if (wordList.contains(newString)) {
                    res.add(newString);
                }
            }
            charCur[i] = temp;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> wordList = Arrays.asList(new String[]{"a","b","c"});
        System.out.println(sol.ladderLength("a", "c", wordList));
    }
}
// @lc code=end

// one direction
// public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//     if (wordList == null || wordList.size() == 0) {
//         return -1;
//     }
//     Set<String> dict = new HashSet<>();
//     for (String s: wordList) {
//         dict.add(s);
//     }

//     Queue<String> q = new LinkedList<>();
//     q.offer(beginWord);
//     dict.remove(beginWord);
//     int minLen = 1;
//     while (!q.isEmpty()) {
//         int size = q.size();
//         while(size-- > 0) {
//             String cur = q.poll();
//             List<String> nexts = transform(dict, cur);
//             for(String next: nexts) {
//                 if (next.equals(endWord)) {
//                     return minLen + 1;
//                 }
//                 q.offer(next);
//             }
//         }
//         minLen++;
//     }
//     return 0;
// }
// private List<String> transform(Set<String> wordList, String cur) {
//     List<String> res = new LinkedList<>();
//     char[] charCur = cur.toCharArray();
//     for (int i = 0; i < charCur.length; i++) {
//         char temp = charCur[i];
//         for (char c = 'a'; c <= 'z'; c++) {
//             charCur[i] = c;
//             String newString = new String(charCur);
//             if (wordList.contains(newString)) {
//                 res.add(newString);
//                 wordList.remove(newString);
//             }
//         }
//         charCur[i] = temp;
//     }
//     return res;
// }