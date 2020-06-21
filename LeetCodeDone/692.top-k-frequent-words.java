import java.util.*;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            return null;
        }

        Map<String, Integer> freqMap = new HashMap<>();
        for (String s: words) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = 
            new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
                @Override
                public int compare(Map.Entry<String, Integer> kv1, Map.Entry<String, Integer> kv2) {
                    if (kv1.getValue() == kv2.getValue()) {
                        return kv1.getKey().compareTo(kv2.getKey());
                    } else {
                        return kv2.getValue() - kv1.getValue();
                    }
                }
        });

        pq.addAll(freqMap.entrySet());
        
        List<String> res = new LinkedList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            Map.Entry<String, Integer> curEntry = pq.poll();
            res.add(curEntry.getKey());
        }



        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 9;
        System.out.println(sol.topKFrequent(words, k));
    }
}
// @lc code=end

