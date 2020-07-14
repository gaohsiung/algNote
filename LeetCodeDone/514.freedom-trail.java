import java.util.*;

/*
 * @lc app=leetcode id=514 lang=java
 *
 * [514] Freedom Trail
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length();
        int keyLen = key.length();
        Map<Integer, Integer> prevIdxMap = new HashMap<>();
        // initial hashmap
        for (int r = 0; r < ringLen; r++) {
            if (ring.charAt(r) == key.charAt(key.length() - 1)) {
                prevIdxMap.put(r, 1);
            }
        }
        // fill up two dp maps
        Map<Integer, Integer> curIdxMap;
        for (int k = keyLen - 2; k >= 0; k--) {
            curIdxMap = new HashMap<>();
            for (int r = 0; r < ringLen; r++) {
                if (ring.charAt(r) != key.charAt(k)) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(Map.Entry<Integer,Integer> e: prevIdxMap.entrySet()) {
                    int prevIdx = e.getKey();
                    int dist = Math.abs(prevIdx - r);
                    dist = dist > ringLen / 2 ? ringLen - dist : dist;
                    min = Math.min(min, dist+e.getValue());
                }
                curIdxMap.put(r, min + 1);
            }
            prevIdxMap = curIdxMap;
        }
        // postprocessing
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> e: prevIdxMap.entrySet()) {
            int prevIdx = e.getKey();
            int dist = Math.abs(prevIdx - 0);
            dist = dist > ringLen / 2 ? ringLen - dist : dist;
            min = Math.min(min, dist+e.getValue());
        }
        return min;
    }
}
// @lc code=end

