/*
 * @lc app=leetcode id=245 lang=java
 *
 * [245] Shortest Word Distance III
 */

// @lc code=start
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dis = Integer.MAX_VALUE;
        boolean isStart = false;
        int start = 0;
        int end;
        for(int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (!isStart) {
                    start = i;
                    isStart = true;
                } else {
                    end = i;
                    if (word1.equals(word2) || (!words[start].equals(words[end]))) {
                        dis = Math.min(dis, end - start);
                    }
                    start = i;
                }
            }
        }
        return dis;
    }
}
// @lc code=end

