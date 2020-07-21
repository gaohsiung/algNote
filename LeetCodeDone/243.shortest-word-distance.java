/*
 * @lc app=leetcode id=243 lang=java
 *
 * [243] Shortest Word Distance
 */

// @lc code=start
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int start = 0;
        int end = 0;
        boolean isStart = false;
        int dis = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (!isStart) {
                    start = i;
                    isStart = true;
                } else {
                    end = i;
                    if (!words[start].equals(words[end])) {
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

