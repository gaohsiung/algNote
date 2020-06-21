import java.util.*;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {

    /*
    public String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        int[] countArray = new int[256];
        int maxcountArray = 0;
        for (int i = 0; i < s.length(); i++) {
            countArray[s.charAt(i)] += 1;
            maxcountArray = Math.max(maxcountArray, countArray[s.charAt(i)]);
        }

        List<List<Character>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxcountArray + 1; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < countArray.length; i++) {
            bucket.get(countArray[i]).add((char) i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bucket.size() - 1; i > 0; i--) {
            int curSize = bucket.get(i).size();
            if (curSize != 0) {
                for (int j = 0; j < curSize; j++) {
                    int reps = i;
                    while (reps-- > 0) {
                        sb.append(bucket.get(i).get(j));
                    }
                }
            }
        }
        return sb.toString();

    }
    */


    
    public String frequencySort(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq 
            = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> kv1, 
                                   Map.Entry<Character, Integer> kv2) {
                    return kv2.getValue() - kv1.getValue();
                }}
            );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> curEntry = pq.poll();
            for(int i = 0; i < curEntry.getValue(); i++) {
                sb.append(curEntry.getKey());
            }

        }
        return sb.toString();

    }
    
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aabccc";
        System.out.println(sol.frequencySort(s));
    }
}
// @lc code=end

